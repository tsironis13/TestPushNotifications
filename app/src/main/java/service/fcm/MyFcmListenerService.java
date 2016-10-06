package service.fcm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.pushnotifications.sample.testpushnotifications.R;

import java.util.HashMap;

/**
 * Created by giannis on 16/9/2016.
 */
public class MyFcmListenerService extends FirebaseMessagingService {

        private static final String debugTag = MyFcmListenerService.class.getSimpleName();
        private PendingIntent resultPendingIntent;

        @Override
        public void onMessageSent(String s) {
            Log.e(debugTag, s);
        }

    @Override
    public void onSendError(String s, Exception e) {
        Log.e(debugTag, e.toString());
    }

    @Override
        public void onMessageReceived(RemoteMessage remoteMessage) {
            String from = remoteMessage.getFrom();
            Log.e(debugTag, from);
            Log.e(debugTag, remoteMessage.getData()+"");
            String text;
            if (remoteMessage.getData().size() > 0) {
                text = remoteMessage.getData().get("hello");
                generateNotification(text, text);
            }
        }

        private void generateNotification(String text, String text2) {
            if (text != null && text2 != null) {
//                if (getResources().getString(R.string.email_notification).equals(data.getString(getResources().getString(R.string.action)))) {
//                    Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(getResources().getString(R.string.mailto)));
//                    resultPendingIntent = PendingIntent.getActivity(this, 0, Intent.createChooser(intent, getResources().getString(R.string.open_with)), PendingIntent.FLAG_UPDATE_CURRENT);
//                }

                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.cast_ic_notification_small_icon)
                        .setContentTitle(text)
                        .setContentText(text2)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentIntent(resultPendingIntent);

                int mNotificationId = 001;
                NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                mNotifyMgr.notify(mNotificationId, nBuilder.build());
            }
        }
    }

