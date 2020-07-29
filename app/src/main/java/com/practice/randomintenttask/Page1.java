package com.practice.randomintenttask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class Page1 extends AppCompatActivity {

    ImageView imageView;
    Button button;

    public void download(View view)
    {
        button.setVisibility(View.GONE);
        ImageDownloader task = new ImageDownloader();
        try {

            Bitmap image = task.execute("https://homepages.cae.wisc.edu/~ece533/images/airplane.png").get();
            if(image == null)
                Toast.makeText(getApplicationContext(), "Sorry! Couldn't load the image. Please try again later.", Toast.LENGTH_LONG).show();
            else imageView.setImageBitmap(image);
        } catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Sorry! Couldn't load the image. Please try again later.", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        String title = getIntent().getStringExtra("title");
        setTitle(title);
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button1);
        Toast.makeText(Page1.this, "Please wait a while after clicking the button...", Toast.LENGTH_SHORT).show();
    }

    public static class ImageDownloader extends AsyncTask<String, Void, Bitmap>
    {

        @Override
        protected Bitmap doInBackground(String... urls)
        {
            URL url;
            try {
                url = new URL(urls[0]);

                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                return bitmap;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
