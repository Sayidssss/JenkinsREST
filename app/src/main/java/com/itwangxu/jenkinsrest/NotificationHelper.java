package com.itwangxu.jenkinsrest;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

/**
 * 创建日期：2018/9/3 15:32
 *
 * @author Sayid 王旭
 * @version 1.0
 * 类说明：
 */
public class NotificationHelper {
    private NotificationManager mNotificationManager;
    private NotificationChannel mNotificationChannel;
    private Context mContext;
    public static final String CHANNEL_ID = "wedo_auto_pack";
    private static final String CHANNEL_NAME = "微度自动打包系统";
    private static final String CHANNEL_DESCRIPTION = "这是微度自动打包系统通知!";

    NotificationHelper(Context base) {
        mContext = base;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_LOW);
            mNotificationChannel.setDescription(CHANNEL_DESCRIPTION);
            getNotificationManager().createNotificationChannel(mNotificationChannel);
        }
    }

    public NotificationCompat.Builder getNotification() {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = new NotificationCompat.Builder(mContext, CHANNEL_ID);
        } else {
            builder = new NotificationCompat.Builder(mContext);
            builder.setPriority(NotificationCompat.PRIORITY_LOW);
        }
        builder.setDefaults(NotificationCompat.FLAG_ONLY_ALERT_ONCE);
        return builder;
    }

    public void notify(int id, NotificationCompat.Builder builder) {
        if (getNotificationManager() != null) {
            getNotificationManager().notify(id, builder.build());
        }
    }

    public void cancel(int id) {
        getNotificationManager().cancel(id);
    }

    public void openChannelSetting(String channelId) {
        Intent intent = new Intent(Settings.ACTION_CHANNEL_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
        intent.putExtra(Settings.EXTRA_CHANNEL_ID, channelId);
        if (mContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null)
            mContext.startActivity(intent);
    }

    public void openNotificationSetting() {
        Intent intent = new Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
        intent.putExtra(Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
        if (mContext.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null)
            mContext.startActivity(intent);
    }

    private NotificationManager getNotificationManager() {
        if (mNotificationManager == null)
            mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        return mNotificationManager;
    }

}