package com.itwangxu.jenkinsrest.net;

import android.os.Environment;

import com.itwangxu.jenkinsrest.MainActivity;

/**
 * 创建日期：2018/8/30 14:26
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class Constant {
    public final static String APP_ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + MainActivity.class.getPackage().getName();
    public final static String DOWNLOAD_DIR = "/downlaod/";
}
