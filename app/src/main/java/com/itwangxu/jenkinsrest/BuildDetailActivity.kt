package com.itwangxu.jenkinsrest

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.itwangxu.jenkinsrest.bean.BuildDetailBean
import com.itwangxu.jenkinsrest.net.Api
import com.itwangxu.jenkinsrest.net.BaseActivity
import com.itwangxu.jenkinsrest.net.BaseObserver
import com.itwangxu.jenkinsrest.utils.TimeUtils
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_build_detail.*
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.Intent
import android.widget.Toast
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.Permission


/**
 * 创建日期：2018/8/27 17:10
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
class BuildDetailActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_build_detail)
        getIntentData()
        getBuildDetail()
    }

    private lateinit var jobName: String
    private lateinit var buildNum: String
    private lateinit var detailBean: BuildDetailBean
    private fun getIntentData() {
        jobName = intent.getStringExtra("jobName")
        buildNum = intent.getStringExtra("buildNum")
    }

    private fun getBuildDetail() {
        Api.get().getBuildDetail(jobName, buildNum).compose(setThread())
                .subscribe(object : BaseObserver<BuildDetailBean>() {
                    override fun onSuccees(t: BuildDetailBean?) {
                        detailBean = t!!
                        initView(t)
                    }

                    override fun onFailure(e: Throwable?, isNetWorkError: Boolean) {
                        Toasty.error(this@BuildDetailActivity, e?.message.toString())
                    }

                })
    }

    @SuppressLint("SetTextI18n")
    private fun initView(t: BuildDetailBean?) {
        status.maxLines = 3
        status.text = "状态：" + t?.result
        displayName.text = "Build全名：" + t?.fullDisplayName
        branch.text = "打包分支：" + getBranchName(t)
        sha1.text = "SHA1：" + getSha1(t)
        buildTime.text = "打包时间：" + TimeUtils.millis2String(t?.timestamp!!)
        if (t.artifacts.isNotEmpty())
            apkName.text = t.artifacts[0].fileName
        else
            downloadButton.visibility = View.GONE
        buildVersion?.text = "构建流水号：${t?.number}"
        changeLogButton.setOnClickListener{ view ->
            detailBean.let {
                val intent = Intent(this@BuildDetailActivity,ChangeLogActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("detailBean",detailBean.changeSet)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
        downloadButton.setOnClickListener{ view ->
            if (isServiceRunning(DownloadIntentService::class.java.name)) {
                Toasty.info(this@BuildDetailActivity, "已有任务正在下载，请查看任务栏", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            AndPermission.with(this@BuildDetailActivity)
                    .runtime()
                    .permission(Permission.Group.STORAGE)
                    .onGranted {
                        val intent = Intent(this@BuildDetailActivity,DownloadIntentService::class.java)
                        intent.putExtra("jobName",jobName)
                        intent.putExtra("buildVersion",buildNum)
                        intent.putExtra("path",t.artifacts[0].relativePath)
                        intent.putExtra("download_id",buildNum.toInt())
                        intent.putExtra("download_file",t.artifacts[0].fileName)
                        startService(intent)
                        Toasty.info(this@BuildDetailActivity, "任务下载后自动安装，请查看任务栏", Toast.LENGTH_SHORT).show()
                    }.onDenied {
                        Toasty.info(this@BuildDetailActivity, "请给予权限以下载apk", Toast.LENGTH_SHORT).show()
                    }.start()



        }

    }

    /**
     * 用来判断服务是否运行.
     *
     * @param className 判断的服务名字
     * @return true 在运行 false 不在运行
     */
    private fun isServiceRunning(className: String): Boolean {

        var isRunning = false
        val activityManager = this
                .getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE)
        if (serviceList.size <= 0) {
            return false
        }
        for (i in serviceList.indices) {
            if (serviceList[i].service.className == className) {
                isRunning = true
                break
            }
        }
        return isRunning
    }
    private fun getSha1(t: BuildDetailBean?): CharSequence? {

        try {
            for (json in t!!.actions) {
                if (json.get("_class") != null)
                    if (json.get("_class").asString == "hudson.plugins.git.util.BuildData") {
                        val jsonObject = json.getAsJsonObject("buildsByBranchName");
                        val iterator = jsonObject.entrySet().iterator()
                        if (iterator.hasNext()) {
                            val entry = iterator.next()
                            val jsonObj1 = entry.value.asJsonObject
                            val jsonObj2 = jsonObj1.getAsJsonObject("revision")
                            return jsonObj2.get("SHA1").asString
                        }
                    }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return "获取SHA1失败"
        }
        return "获取SHA1失败"


    }

    private fun getBranchName(t: BuildDetailBean?): String {
        try {
            for (json in t!!.actions) {
                if (json.get("_class") != null)
                    if (json.get("_class").asString == "hudson.plugins.git.util.BuildData") {
                        val jsonObject = json.getAsJsonObject("buildsByBranchName");
                        val iterator = jsonObject.entrySet().iterator()
                        if (iterator.hasNext()) {
                            val entry = iterator.next()
                            return entry.key
                        }
                    }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return "获取分支失败"
        }
        return "获取分支失败"
    }
}