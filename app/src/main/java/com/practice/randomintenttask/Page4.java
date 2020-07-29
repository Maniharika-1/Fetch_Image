package com.practice.randomintenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Page4 extends AppCompatActivity {

    ImageView imageView;
    Button button;

    public void download(View view)
    {
        button.setVisibility(View.GONE);
        Page1.ImageDownloader task = new Page1.ImageDownloader();
        try {
            Bitmap image = task.execute("https://homepages.cae.wisc.edu/~ece533/images/fruits.png").get();
            if(image == null)
                Toast.makeText(getApplicationContext(), "Sorry! Couldn't load the image. Please try again later.", Toast.LENGTH_LONG).show();
            else imageView.setImageBitmap(image);
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Sorry! Couldn't load the image. Please try again later.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        imageView = findViewById(R.id.imageView4);
        button = findViewById(R.id.button4);
        Toast.makeText(Page4.this, "Please wait a while after clicking the button...", Toast.LENGTH_SHORT).show();
    }
}
