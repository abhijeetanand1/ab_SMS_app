package com.example.ab_sms_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.TextView;
import android.widget.Toast;

public class ReceiveSMS extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "SMS Received", Toast.LENGTH_SHORT).show();

        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Bundle bundle = intent.getExtras();

            SmsMessage[] allSms= null;
            String sms_sender=null;

            if(bundle != null){
                try{
                    Object[] pdus= (Object[]) bundle.get("pdus");
                    allSms = new SmsMessage[pdus.length];

                    for(int i=0; i<allSms.length;i++){
                        allSms[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        sms_sender = allSms[i].getOriginatingAddress();
                        String SmsBody = allSms[i].getMessageBody();

                        Toast.makeText(context, "From:" + sms_sender +"\nMessage:"+ SmsBody, Toast.LENGTH_LONG).show();

                    }

                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }

    }
}
