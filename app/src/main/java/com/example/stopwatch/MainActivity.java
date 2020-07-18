package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvSplash, tvSubSplash;
    private Button btnget;
    private Animation atg,a_btgone,a_btgtwo;
    private ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = findViewById(R.id.tvSplash);
        tvSubSplash = findViewById(R.id.tvSubSplash);
        btnget = findViewById(R.id.btnget);
        ivSplash = findViewById(R.id.ivSplash);

        //load animation
        atg = AnimationUtils.loadAnimation(this,R.anim.atg);
        a_btgone = AnimationUtils.loadAnimation(this,R.anim.a_btgone);
        a_btgtwo = AnimationUtils.loadAnimation(this,R.anim.a_btgwo);

        //passing animation
        ivSplash.startAnimation(atg);
        tvSplash.startAnimation(a_btgone);
        tvSubSplash.startAnimation(a_btgone);
        btnget.startAnimation(a_btgtwo);

        intent();


    }

    public void intent(){
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StopWatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                finish();
            }
        });
    }
}
