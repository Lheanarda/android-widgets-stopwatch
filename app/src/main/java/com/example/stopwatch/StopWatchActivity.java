package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    private Button btnStart,btnStop;
    private ImageView ivAnchor,ivcircle;
    private Animation a_roundingalone,a_roundingstop, atg;
    private Chronometer chronotimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnStart = findViewById(R.id.btnstart);
        btnStop = findViewById(R.id.btnstop);
        ivAnchor = findViewById(R.id.ivAnchor);
        chronotimer = findViewById(R.id.chronotimer);
        ivcircle = findViewById(R.id.ivCircle);

        //load animation
        a_roundingalone = AnimationUtils.loadAnimation(this,R.anim.a_roundingalone);
        a_roundingstop = AnimationUtils.loadAnimation(this,R.anim.a_roundingstop);
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);

        //optional animation
        btnStop.setAlpha(0); //Allpha controls visibility of object

        //disabled button
        btnStop.setEnabled(false);

        //passing animation
        ivcircle.startAnimation(atg);
        ivAnchor.startAnimation(atg);
        btnStart.startAnimation(atg);
        chronotimer.startAnimation(atg);

        StartStopWatch();
        StopStopWatch();

    }

    public void StartStopWatch(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //passing animation
                ivAnchor.startAnimation(a_roundingalone);
                btnStop.animate().alpha(1).translationY(-120).setDuration(300).start();
                btnStop.setEnabled(true);
                btnStart.animate().alpha(0).setDuration(300).start();
                btnStart.setEnabled(false);

                //start time
                chronotimer.setBase(SystemClock.elapsedRealtime());
                chronotimer.start();
            }
        });
    }

    public void StopStopWatch(){
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animation
                ivAnchor.startAnimation(a_roundingstop);

                btnStart.animate().alpha(1).setDuration(300).start();
                btnStart.setEnabled(true);
                btnStop.animate().alpha(0).translationY(120).setDuration(300).start();
                btnStop.setEnabled(false);
                //stop time
                chronotimer.setBase(SystemClock.elapsedRealtime());
                chronotimer.stop();
            }
        });
    }
}
