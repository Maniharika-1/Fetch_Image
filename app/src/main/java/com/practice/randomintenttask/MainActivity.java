package com.practice.randomintenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public void displayImage(View view)
    {
        Random randomNumberGenerator = new Random();
        int randomNumber =  randomNumberGenerator.nextInt(4);
        Intent intent;
        if(randomNumber == 0)
        {
            intent = new Intent(this, Page1.class);
            intent.putExtra("title", "Picture 1");
            startActivity(intent);
        }
        else if(randomNumber == 1)
        {
            intent = new Intent(this, Page2.class);
            intent.putExtra("title", "Picture 2");
            startActivity(intent);
        }
        else if(randomNumber == 2)
        {
            intent = new Intent(this, Page3.class);
            intent.putExtra("title", "Picture 3");
            startActivity(intent);
        }
        else if(randomNumber == 3)
        {
            intent = new Intent(this, Page4.class);
            intent.putExtra("title", "Picture 4");
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
