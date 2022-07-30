package com.convertify.alkhaleej;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MyNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

    private Application application;
    String URL = null;

    public MyNotificationOpenedHandler(Application application) {
        this.application = application;
        Log.i("oooottttt", "urlExtttttoooo=" + application);
    }

    @Override
    public void notificationOpened(OSNotificationOpenResult result) {

        JSONObject data = result.notification.payload.additionalData;
        if (data != null) {
            try {
                URL = data.optString("url", null);
                Log.i("oooottttt", "urlExtttttoooousa=" + URL);
            } catch (Exception e) {
                e.printStackTrace();
                Log.i("ooootttttnotopen", "urlExtttttoooonotopen=" + URL);
            }
        }

        OSNotificationAction.ActionType actionType = result.action.type;
        if (actionType == OSNotificationAction.ActionType.ActionTaken)
            Log.i("OneSignalExample", "Button pressed with id: " + result.action.actionID);

        startApp();
    }

    private void startApp() {
        Intent intent = new Intent(application, MainActivity.class)
                //.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("ONESIGNAL_URL",URL);
        application.startActivity(intent);

    }
}