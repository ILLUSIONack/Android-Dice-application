package com.example.usmansiddiqui.diceapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    private Button DieBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DieBtn = findViewById(R.id.DieBtn);

        DieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToDie();
            }
        });
    }

    public void backToDie(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
