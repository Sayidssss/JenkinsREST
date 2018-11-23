package com.itwangxu.jenkinsrest.net;

/**
 * 创建日期：2018/8/30 14:26
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public interface DownloadCallBack {
    void onProgress(int progress);

    void onCompleted();

    void onError(String msg);
}
