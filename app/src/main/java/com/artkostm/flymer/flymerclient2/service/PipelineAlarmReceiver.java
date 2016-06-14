package com.artkostm.flymer.flymerclient2.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PipelineAlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;
    public static final String ACTION = "com.artkostm.flymer.flymerclient2.service.alarm";

    public PipelineAlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent i) {
        final Intent intent = new Intent(context, PipelineService.class);
        context.startService(intent);
    }
}
