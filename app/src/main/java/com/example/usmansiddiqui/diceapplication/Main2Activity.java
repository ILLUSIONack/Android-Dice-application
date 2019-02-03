package com.example.usmansiddiqui.diceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private Button DieBtn;
    private ImageView spinnerImage;

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
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        spinnerImage.startAnimation(animation);
    }
    public void backToDie(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
