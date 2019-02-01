package com.example.usmansiddiqui.diceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDice;
    private Button spinnerBtn;
    private Random rng = new Random();

    private int[] diceImages = {
            R.drawable.dice1,
            R.drawable.dice2,
            R.drawable.dice3,
            R.drawable.dice4,
            R.drawable.dice5,
            R.drawable.dice6
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDice = findViewById(R.id.ImageDice);
        spinnerBtn = findViewById(R.id.SpinnerBtn);

        spinnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSpinner();
            }
        });
        imageViewDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceAnim();
                TimerTask task = new TimerTask() {
                    int tick = 0;
                    @Override
                    public void run() {
                        if(tick>6){
                            rollDice(diceImages);
                            cancel();
                        }
                        rollDice(diceImages);
                        tick++;
                    }
                };

                Timer timer = new Timer();
                timer.schedule(task, 1, 100);
            }
        });
    }

    public void openSpinner(){
        Intent intent = new Intent(this,Main2Activity.class);
        startActivity(intent);
    }

    private void diceAnim(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim);
        imageViewDice.startAnimation(animation);
    }

    private void rollDice(int[]diceArray){
        int randomNumber = rng.nextInt(6);
        int randomDice = diceArray[randomNumber];
        imageViewDice.setImageResource(randomDice);
    }

}
