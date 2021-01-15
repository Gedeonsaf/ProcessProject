package com.example.processapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btnafficher);
        image = (ImageView) findViewById(R.id.imageView);
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        Bitmap b = loadImageFromNetwork("https://www.google.com/search?rlz=1C1XXVF_frCD932CD932&sxsrf=ALeKk00vErK7rRPCsP7MrAPQ0IBLTe2OnA:1610508260243&source=univ&tbm=isch&q=image&sa=X&ved=2ahUKEwi9pInm-pfuAhXRxVkKHTGgBhYQ7Al6BAgBEEo&biw=1366&bih=568#imgrc=eSkpjPh1a_fCJM");
                        image.setImageBitmap(b);
                    }
                }).start();

//                new Thread(new Runnable() {
//                    public void run() {
//                        final Bitmap bitmap = loadImageFromNetwork("http://example.com/image.png");
//                        image.post(new Runnable() {
//                            public void run() {
//                                image.setImageBitmap(bitmap);
//                            }
//                        });
//                    }
//                }).start();
            }
        });


    }
}