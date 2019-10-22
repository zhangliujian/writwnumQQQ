package com.example.writwnum;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            public void run() {
                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                finish();
            }
        };
        timer.schedule(timerTask,5000);
    }
}
