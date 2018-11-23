package com.itwangxu.jenkinsrest;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.itwangxu.jenkinsrest.bean.JobListBean;
import com.itwangxu.jenkinsrest.net.Api;
import com.itwangxu.jenkinsrest.net.BaseActivity;
import com.itwangxu.jenkinsrest.net.BaseObserver;

import java.util.List;

/**
 * 创建日期：2018/8/27 15:11
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class MainActivity2 extends BaseActivity {
    private List<JobListBean.JobsBean> mJobsBeans ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Api.get().getJobList().compose(setThread())
                .subscribe(new BaseObserver<Object>() {
                    @Override
                    protected void onSuccees(Object o) {

                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) {

                    }
                });

        for (JobListBean.JobsBean bean:mJobsBeans){

        }
    }

    public class JobSummaryAdapter extends FragmentPagerAdapter{

        public JobSummaryAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }
    }
}
