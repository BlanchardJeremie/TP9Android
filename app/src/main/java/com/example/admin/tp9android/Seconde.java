package com.example.admin.tp9android;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Seconde extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconde);



    }
    @Override
    protected void onPause(){
        super.onPause();
        notify("onPause");
        Toast toast = Toast.makeText(this,R.string.messagePause,Toast.LENGTH_LONG);
        toast.show();

    }
    @Override
    protected void onResume(){
        super.onResume();
        notify("onResume");
        Toast toast = Toast.makeText(this,R.string.messageResume,Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        notify("onStop");
        Toast toast = Toast.makeText(this,R.string.messageStop,Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        notify("onDestroy");
        Toast toast = Toast.makeText(this,R.string.messageDestroy,Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        notify("RestoreInstanceState");
        Toast toast = Toast.makeText(this,R.string.messageRestoreInstanceState,Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        notify("RestoreInstanceState");
        Toast toast = Toast.makeText(this,R.string.messageSaveInstanceState,Toast.LENGTH_LONG);
        toast.show();
    }

    public void cliclpage1(View view) {
        Intent premiereActivite = new Intent(Seconde.this, Principale.class);

        startActivity(premiereActivite);
    }

    private void notify(String methodeName){
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = new Notification.Builder(this)
                .setContentTitle(methodeName + " " + strings[strings.length - 1]).setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(name).build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify((int)System.currentTimeMillis(),noti);
    }
}
