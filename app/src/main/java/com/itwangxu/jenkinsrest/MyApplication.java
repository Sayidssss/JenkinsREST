package com.itwangxu.jenkinsrest;

import android.app.Application;
import android.content.Context;

/**
 * 创建日期：2018/8/30 14:29
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static Context getInstance() {
        return sInstance;
    }

}
