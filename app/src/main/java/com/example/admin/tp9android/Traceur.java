package com.example.admin.tp9android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Traceur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traceur);

    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast toast = Toast.makeText(this, R.string.messagePause, Toast.LENGTH_LONG);
        toast.show();

    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast toast = Toast.makeText(this, R.string.messageResume, Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast toast = Toast.makeText(this, R.string.messageStop, Toast.LENGTH_LONG);
        toast.show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast toast = Toast.makeText(this, R.string.messageDestroy, Toast.LENGTH_LONG);
        toast.show();
    }

}
