package com.example.admin.tp9android;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Principale extends AppCompatActivity {
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);




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

    public void clickpage2(View view) {
        Intent secondeActivite = new Intent(Principale.this, Seconde.class);

        startActivity(secondeActivite);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        notify("RestoreInstanceState");
        Toast toast = Toast.makeText(this,R.string.messageRestoreInstanceState,Toast.LENGTH_LONG);
        toast.show();

        int save = savedInstanceState.getInt("intincrementer",i);
        i = save;
        TextView chiffremonter = (TextView) findViewById(R.id.chiffre);
        chiffremonter.setText(String.valueOf(i));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        notify("RestoreInstanceState");
        Toast toast = Toast.makeText(this,R.string.messageSaveInstanceState,Toast.LENGTH_LONG);
        toast.show();

        outState.putInt("intincrementer",i);
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

    public void clickincrement(View view) {
        i += 1;
        TextView chiffremonter = (TextView) findViewById(R.id.chiffre);
        chiffremonter.setText(String.valueOf(i));
    }
}
