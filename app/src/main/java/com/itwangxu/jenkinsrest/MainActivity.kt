package com.itwangxu.jenkinsrest

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.itwangxu.jenkinsrest.bean.JobListBean
import com.itwangxu.jenkinsrest.net.Api
import com.itwangxu.jenkinsrest.net.BaseActivity
import com.itwangxu.jenkinsrest.net.BaseObserver
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private lateinit var mJobsBeans: List<JobListBean.JobsBean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        initTabLayout()
        Api.get().jobList.compose(setThread())
                .subscribe(object : BaseObserver<JobListBean>() {
                    override fun onSuccees(o: JobListBean) {
                        mJobsBeans = o.jobs
                        initTabLayout()
                    }

                    override fun onFailure(e: Throwable, isNetWorkError: Boolean) {
                        e.printStackTrace()
                    }
                })
    }

    private fun initTabLayout() {
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
//        for (bean in mJobsBeans) {
//            tabLayout.addTab(tabLayout.newTab().setText(bean.name))
//        }
        tabLayout.setupWithViewPager(viewPager)
        viewPager.adapter = JobSummaryAdapter(supportFragmentManager)
    }


    inner class JobSummaryAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getPageTitle(position: Int): CharSequence? {
            return mJobsBeans[position].name
        }
        override fun getItem(i: Int): Fragment? {
            val fragment = JobDetailFragment()
            val bundle =  Bundle()
            bundle.putString("jobName",mJobsBeans[i].name)
            fragment.arguments = bundle
            return fragment
        }

        override fun getCount(): Int {
            return mJobsBeans.size
        }
    }
}
