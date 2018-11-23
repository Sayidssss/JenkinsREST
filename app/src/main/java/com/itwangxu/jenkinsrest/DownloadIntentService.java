package com.itwangxu.jenkinsrest;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
import android.widget.Toast;

import com.itwangxu.jenkinsrest.net.Api;
import com.itwangxu.jenkinsrest.net.Constant;
import com.itwangxu.jenkinsrest.net.DownloadCallBack;
import com.itwangxu.jenkinsrest.net.HttpConfig;
import com.itwangxu.jenkinsrest.net.SPDownloadUtil;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Random;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * 创建日期：2018/8/31 15:58
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class DownloadIntentService extends IntentService {
    private static final String TAG = "DownloadIntentService";
    private String mDownloadFileName;
    private NotificationManagerCompat mNotificationManagerCompat;
    private NotificationCompat.Builder mNotification;
    private String jobName;
    private String buildVersion;
    private String path;
    private int downloadId;
    NotificationHelper mNotificationHelper;

    public DownloadIntentService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        mNotificationHelper = new NotificationHelper(DownloadIntentService.this);
        jobName = intent.getExtras().getString("jobName");
        buildVersion = intent.getExtras().getString("buildVersion");
        path = intent.getExtras().getString("path");
        downloadId = intent.getExtras().getInt("download_id");
        mDownloadFileName = intent.getExtras().getString("download_file");
        String downloadUrl = HttpConfig.BASE_URL + "job/" + jobName + "/" + buildVersion + "/artifact/" + path;
        String filePath = Constant.APP_ROOT_PATH + Constant.DOWNLOAD_DIR + jobName + File.separator + buildVersion + File.separator + mDownloadFileName;
        final File file = new File(filePath);
        long range = 0;
        int progress = 0;
        if (file.exists()) {
            range = SPDownloadUtil.getInstance().get(downloadUrl, 0);
            progress = (int) (range * 100 / file.length());
            if (range == file.length()) {
                installApp(file);
                return;
            }
        }
        mNotificationManagerCompat = NotificationManagerCompat.from(DownloadIntentService.this);
        Log.d(TAG, "range = " + range);
        final int randomInt = new Random().nextInt(Integer.MAX_VALUE);
        mNotification = mNotificationHelper.getNotification();
        mNotification.setSmallIcon(R.mipmap.app);
        mNotification.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.app));
        mNotification.setProgress(100,0,false);
        mNotification.setContentTitle(jobName+" "+buildVersion);
        mNotification.setContentText(mDownloadFileName);
        mNotification.setAutoCancel(false);
        mNotificationHelper.notify(randomInt,mNotification);
//        NotificationCompat.Builder builder  = new NotificationCompat.Builder(getApplicationContext(),)
        downloadFile(range, jobName, buildVersion, path, mDownloadFileName, new DownloadCallBack() {
            @Override
            public void onProgress(int progress) {
                mNotification.setProgress(100,progress,false);
                mNotificationHelper.notify(randomInt,mNotification);
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "下载完成");
                mNotificationManagerCompat.cancel(randomInt);
                installApp(file);
            }

            @Override
            public void onError(String msg) {
                mNotificationManagerCompat.cancel(randomInt);
                Log.d(TAG, "下载发生错误--" + msg);
            }
        });
    }

    private void installApp(final File file) {
        AndPermission.with(this)
                .install()
                .file(file)
                .onGranted(new Action<File>() {
                    @Override
                    public void onAction(File data) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
//                            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
//                        } else {//Android7.0之后获取uri要用contentProvider
//                            Uri uri = AndPermission.getFileUri(getBaseContext(), file);
//                            intent.setDataAndType(uri, "application/vnd.android.package-archive");
//                            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                        }
//                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        getBaseContext().startActivity(intent);

                    }
                })
                .onDenied(new Action<File>() {
                    @Override
                    public void onAction(File data) {
                        Toast.makeText(DownloadIntentService.this, "请给予权限以安装apk", Toast.LENGTH_SHORT).show();
                    }
                }).start();

    }


    public void downloadFile(final long range, String jobName, String buildVersion, String path, final String fileName, final DownloadCallBack downloadCallback) {
        //断点续传时请求的总长度
        final String downloadUrl = HttpConfig.BASE_URL + "job/" + jobName + "/" + buildVersion + "/artifact/" + path;
        final String filePath = Constant.APP_ROOT_PATH + Constant.DOWNLOAD_DIR + jobName + File.separator + buildVersion + File.separator;

        File file = new File(filePath, fileName);
        String totalLength = "-";
        if (file.exists()) {
            totalLength += file.length();
        }

        Api.get().getApk("bytes=" + Long.toString(range) + totalLength, jobName, buildVersion, path)
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        RandomAccessFile randomAccessFile = null;
                        InputStream inputStream = null;
                        long total = range;
                        long responseLength = 0;
                        try {
                            byte[] buf = new byte[2048];
                            int len = 0;
                            responseLength = responseBody.contentLength();
                            inputStream = responseBody.byteStream();
                            File file = new File(filePath, fileName);
                            File dir = new File(filePath);
                            if (!dir.exists()) {
                                dir.mkdirs();
                            }
                            randomAccessFile = new RandomAccessFile(file, "rwd");
                            if (range == 0) {
                                randomAccessFile.setLength(responseLength);
                            }
                            randomAccessFile.seek(range);

                            int progress = 0;
                            int lastProgress = 0;

                            while ((len = inputStream.read(buf)) != -1) {
                                randomAccessFile.write(buf, 0, len);
                                total += len;
                                lastProgress = progress;
                                progress = (int) (total * 100 / randomAccessFile.length());
                                if (progress > 0 && progress != lastProgress) {
                                    downloadCallback.onProgress(progress);
                                }
                            }
                            downloadCallback.onCompleted();
                        } catch (Exception e) {
                            Log.d(TAG, e.getMessage());
                            downloadCallback.onError(e.getMessage());
                            e.printStackTrace();
                        } finally {
                            try {
                                SPDownloadUtil.getInstance().save(downloadUrl, total);
                                if (randomAccessFile != null) {
                                    randomAccessFile.close();
                                }

                                if (inputStream != null) {
                                    inputStream.close();
                                }

                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        downloadCallback.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
