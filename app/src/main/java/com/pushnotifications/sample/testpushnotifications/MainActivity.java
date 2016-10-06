package com.pushnotifications.sample.testpushnotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity {

    private static final String debugTag = MainActivity.class.getSimpleName();
    private AtomicInteger atomicInteger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sendMessageBtn = (Button) findViewById(R.id.sendMessageBtn);
        sendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int msgID = 1010;
                atomicInteger = new AtomicInteger();
                long senderID = 998915164374L;
                FirebaseMessaging fm = FirebaseMessaging.getInstance();
                Log.e(debugTag, fm.toString());
                fm.send(new RemoteMessage.Builder("998915164374@gcm.googleapis.com")
                        .setMessageId(Integer.toString(atomicInteger.incrementAndGet()))
                        .addData("my_message", "Hello World")
                        .addData("my_action","SAY_HELLO")
                        .build());


            }
        });
    }

    public static void kalase(String token) {
        Log.e(debugTag, token);
    }
}
