package service.fcm;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.pushnotifications.sample.testpushnotifications.MainActivity;

/**
 * Created by giannis on 16/9/2016.
 */
public class MyInstanceIDListenerService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.e("", "Refreshed token: " + refreshedToken);
        MainActivity.kalase(refreshedToken);
    }
}
