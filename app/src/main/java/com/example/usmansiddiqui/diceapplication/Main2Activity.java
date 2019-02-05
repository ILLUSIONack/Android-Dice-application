package com.example.usmansiddiqui.diceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private Button DieBtn;
    private ImageView spinnerImage;
    private Random rng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spinnerImage = findViewById(R.id.SpinnerImage);
        DieBtn = findViewById(R.id.DieBtn);

        spinnerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin();
            }
        });
        DieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToDie();
            }
        });
    }
    public void spin(){
        RotateAnimation rotate = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(1000);
        rotate.setFillAfter(true);
        rotate.setInterpolator(new DecelerateInterpolator());
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        spinnerImage.startAnimation(rotate);
    }
    
    public void backToDie(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
