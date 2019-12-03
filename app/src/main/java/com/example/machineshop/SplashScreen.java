package com.example.machineshop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 4000;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //startActivity(new Intent(this, MainActivity.class));
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Intent intent = new Intent(SplashScreen.this, MainActivity.class);
              startActivity(intent);
              finish();
          }
      }, SPLASH_DISPLAY_LENGTH);

    }

}