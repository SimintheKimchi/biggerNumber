package com.example.biggernumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button buttonLeft;
    private Button buttonRight;
    private TextView textViewScore;
    private int score;
    private int leftNumber;
    private int rightNumber;

    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        randomizeAndUpdateDisplay();
    }

    private void randomizeAndUpdateDisplay() {
        //accesses string resources using .getResources()
        String scoreString = getResources().getString(R.string.main_score);
        textViewScore.setText(scoreString + score);

        //creates random number
        randomizeNumbers();

        buttonLeft.setText(String.valueOf(leftNumber));
        buttonRight.setText(String.valueOf(rightNumber));

    }

    private void randomizeNumbers() {
        int range = (MAX_NUM - MIN_NUM) + 1;
        leftNumber = MIN_NUM + (int) (Math.random() * range);
        rightNumber = MIN_NUM + (int) (Math.random() * range);
        while(rightNumber == leftNumber) {
            rightNumber = MIN_NUM + (int) (Math.random() * range);
        }
    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        textViewScore = findViewById(R.id.main_score);
    }

    public void onLeftClick(View view) {
        String message;
        if(leftNumber > rightNumber){
            message = "Correct!";
            score++;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else{
            message = "Good job...";
            score--;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        randomizeAndUpdateDisplay();
    }

    public void onRightClick(View view) {
        String message;
        if(rightNumber > leftNumber){
            message = "Correct!";
            score++;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else{
            message = "Good job...";
            score--;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

        randomizeAndUpdateDisplay();
    }
}
