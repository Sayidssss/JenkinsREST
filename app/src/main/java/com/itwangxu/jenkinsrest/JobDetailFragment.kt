package com.itwangxu.jenkinsrest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.itwangxu.jenkinsrest.bean.JobListBean
import com.itwangxu.jenkinsrest.bean.JobSummaryBean
import com.itwangxu.jenkinsrest.net.Api
import com.itwangxu.jenkinsrest.net.BaseObserver
import com.itwangxu.jenkinsrest.utils.TimeUtils
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.fragment_job_detail.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import okhttp3.ResponseBody
import java.io.IOException


/**
 * 创建日期：2018/8/27 15:33
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */


class JobDetailFragment : BaseFragment(), View.OnClickListener {

    private var title: TextView? = null
    private var status: TextView? = null
    private var buildVersion: TextView? = null
    private var buildTime: TextView? = null
    private var buildHealthReport: TextView? = null
    private var description: TextView? = null
    private var score: TextView? = null
    private var swipeView: SwipeRefreshLayout? = null
    private var lastBuildLL: LinearLayout? = null
    private lateinit var jobName: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_job_detail, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        jobName = arguments?.get("jobName") as String
        swipeView = view.findViewById(R.id.swipeView) as SwipeRefreshLayout
        title = view.findViewById<View>(R.id.title) as TextView
        status = view.findViewById<View>(R.id.status) as TextView
        buildVersion = view.findViewById<View>(R.id.buildVersion) as TextView
        buildTime = view.findViewById<View>(R.id.buildTime) as TextView
        buildHealthReport = view.findViewById<View>(R.id.buildHealthReport) as TextView
        description = view.findViewById<View>(R.id.description) as TextView
        score = view.findViewById<View>(R.id.score) as TextView
        lastBuildLL = view.findViewById<View>(R.id.lastBuildLL) as LinearLayout
        buildHistory.setOnClickListener(this)
        triggerBuild.setOnClickListener(this)
        swipeView.let {
            it?.setOnRefreshListener {
                loadData()
            }
        }
        loadData()

    }


    private fun loadData() {
        Api.get().getJobSummary(jobName).compose(setThread())
                .subscribe(object : BaseObserver<JobSummaryBean>() {
                    @SuppressLint("SetTextI18n")
                    override fun onSuccees(t: JobSummaryBean?) {
                        swipeView?.isRefreshing = false
                        t.let { it2 ->
                            it2?.lastBuild.let { it ->
                                if (it?.result == "SUCCESS") {
                                    status?.text = "状态：成功"
                                } else if (it?.result == "ABORTED") {
                                    status?.text = "状态：已取消"
                                } else if (it?.result == "FAILURE") {
                                    status?.text = "状态：失败"
                                } else {
                                    status?.text = "状态：打包中"
                                }
                                buildVersion?.text = "构建流水号：${it?.number}"

                                buildTime?.text = "构建时间：" + TimeUtils.millis2String(it?.timestamp!!)
                                lastBuildLL?.setOnClickListener { _ ->
                                    val intent = Intent(activity, BuildDetailActivity::class.java)
                                    intent.putExtra("jobName", jobName)
                                    intent.putExtra("buildNum", it2?.lastBuild?.number.toString())
                                    activity?.startActivity(intent)
                                }
                            }
                            it2?.healthReport.let {
                                description?.text = it?.get(0)?.description
                                score?.text = "构建评分：" + it?.get(0)?.score.toString()
                            }


                        }
                    }

                    override fun onFailure(e: Throwable?, isNetWorkError: Boolean) {
                        swipeView?.isRefreshing = false
                    }

                })

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.buildHistory -> {
            }
            R.id.triggerBuild -> {
                Api.get().triggerBuild(jobName).compose(setThread())
                        .subscribe(object :BaseObserver<ResponseBody>(){
                            override fun onSuccees(t: ResponseBody?) {
                                Toasty.success(context!!,"触发构建成功，请勿多次点击").show()
                            }

                            override fun onFailure(e: Throwable?, isNetWorkError: Boolean) {
                                Toasty.success(context!!,e!!.message.toString()).show()
                            }

                        })





//                        .enqueue(object : Callback {
//                    override fun onFailure(call: Call, e: IOException) {
//                        Toasty.error(activity!!, e.message!!).show()
//                    }
//
//                    override fun onResponse(call: Call, response: Response) {
//                        if (response.code() == 201) {
//                            Toasty.success(activity!!, "触发构建成功，请勿多次点击").show()
//                            loadData()
//                        }
//                    }
//
//                })

            }
        }
    }
}