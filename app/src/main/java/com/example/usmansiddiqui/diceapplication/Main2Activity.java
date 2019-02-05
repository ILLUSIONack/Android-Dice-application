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
import android.widget.Toast;

import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    private Button DieBtn;
    private ImageView spinnerImage;
    private int degree = 0, oldDegree = 0;

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
        Random rng = new Random();
        oldDegree = degree % 360;
        degree = rng.nextInt(360) + 1440;
        RotateAnimation rotate = new RotateAnimation(oldDegree,degree,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(3000);
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
