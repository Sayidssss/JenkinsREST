package com.itwangxu.jenkinsrest.net;

import com.itwangxu.jenkinsrest.bean.BuildDetailBean;
import com.itwangxu.jenkinsrest.bean.JobListBean;
import com.itwangxu.jenkinsrest.bean.JobSummaryBean;

import io.reactivex.Observable;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * 创建日期：2018/8/27 14:55
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public interface BaseApiService {
    @GET("api/json")
    Observable<JobListBean> getJobList();

    @GET("job/{jobName}/api/json?tree=lastBuild[number,id,timestamp,result],name,healthReport[description,iconClassName,iconUrl,score]")
    Observable<JobSummaryBean> getJobSummary(@Path("jobName") String jobName);

    @GET("job/{jobName}/{buildVersion}/api/json")
    Observable<BuildDetailBean> getBuildDetail(@Path("jobName") String jobName,@Path("buildVersion") String buildVersion);

    @Streaming
    @GET("job/{jobName}/{buildVersion}/artifact/{path}")
    Observable<ResponseBody> getApk(@Header("Range") String range,@Path("jobName") String jobName, @Path("buildVersion") String buildVersion, @Path("path") String path);

    @POST("job/{jobName}/build")
    Observable<ResponseBody> triggerBuild(@Path("jobName") String jobName);
}
