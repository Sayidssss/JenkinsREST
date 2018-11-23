package com.itwangxu.jenkinsrest.net;

/**
 * 创建日期：2018/8/27 14:13
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class Api {
    private static BaseApiService apiService = ServiceGenerater.createService(BaseApiService.class,"admin","123456");

    public static BaseApiService get(){
        return apiService;
    }


}
