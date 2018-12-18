package com.example.prateek.clientside;

import android.app.Application;

public class Globalclass extends Application {
        private String clientId;
        public String getClientId() {
            return clientId;
        }

        public void setClientId(String name) {
            clientId = name;
        }


    }