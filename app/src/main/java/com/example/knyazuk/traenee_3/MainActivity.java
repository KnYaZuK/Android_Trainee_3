package com.example.knyazuk.traenee_3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyImageView myImageView;

    private Button plusButton;
    private Button minusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        myImageView = findViewById(R.id.image);

        plusButton = findViewById(R.id.plus);
        minusButton = findViewById(R.id.minus);

        myImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                myImageView.setStartPoint((int) event.getX(), (int) event.getY());
                return true;
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.incSize();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myImageView.decSize();
            }
        });
    }
}
