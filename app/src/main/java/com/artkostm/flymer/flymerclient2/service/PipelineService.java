package com.artkostm.flymer.flymerclient2.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

public class PipelineService extends IntentService {

    public PipelineService() {
        super("PipelineService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Toast toast = Toast.makeText(this, "service call", Toast.LENGTH_SHORT);
            toast.show();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            toast.cancel();
        }
    }
}
