package com.example.covid_19trackernepal.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.example.covid_19trackernepal.R;


public class Activity_SplashScreen extends AppCompatActivity {

    ProgressBar splashProgress;
    public static int SPLASH_TIME_OUT=3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashProgress = findViewById(R.id.splashProgress);
        playProgress();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplicationContext(), Activity_Welcome.class);
                startActivity(i);
                //overridePendingTransition(R.anim.anim_slide_out_right,R.anim.anim_slide_in_right);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 195
        ).setDuration(6000).start();
    }
}
