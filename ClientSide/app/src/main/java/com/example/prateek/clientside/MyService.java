package com.example.prateek.clientside;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.MqttClient;

import helper.MqttHelper;

public class MyService extends Service {
    public MyService() {
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle extras = intent.getExtras();
        if(extras == null)
            Log.d("Service","null");
        else {
            String username = (String) extras.get("username");
            String password = (String) extras.get("password");
            //Log.d("Service username", "username :" + username);

            //public MqttAndroidClient mqttAndroidClient;
            //mqttAndroidClient = new MqttAndroidClient(context, serverUri, MqttClient.generateClientId());

            MqttHelper mqtth = new MqttHelper(getApplicationContext(),MqttClient.generateClientId());
            mqtth.connect(username,password);
            //Log.e("MyService ", "service client id "+mqtth.getClientId());
            final Globalclass globalVariable = (Globalclass) getApplicationContext();
            globalVariable.setClientId(mqtth.getClientId());
            Log.e("MyService ", "service client id "+globalVariable.getClientId());
        }
        return START_NOT_STICKY;

    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
