package com.itwangxu.jenkinsrest.net;

import android.content.Context;
import android.content.SharedPreferences;

import com.itwangxu.jenkinsrest.MyApplication;

/**
 * 创建日期：2018/8/30 14:29
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class SPDownloadUtil {
    private static SharedPreferences mSharedPreferences;
    private static SPDownloadUtil instance;

    private SPDownloadUtil() {
    }

    public static SPDownloadUtil getInstance() {
        if (mSharedPreferences == null || instance == null) {
            synchronized (SPDownloadUtil.class) {
                if (mSharedPreferences == null || instance == null) {
                    instance = new SPDownloadUtil();
                    mSharedPreferences = MyApplication.getInstance().getSharedPreferences("downloadSp", Context.MODE_PRIVATE);
                }
            }
        }
        return instance;
    }

    /**
     * 清空数据
     *
     * @return true 成功
     */
    public boolean clear() {
        return mSharedPreferences.edit().clear().commit();
    }

    /**
     * 保存数据
     *
     * @param key   键
     * @param value 保存的value
     */
    public boolean save(String key, long value) {
        return mSharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public long get(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

}
