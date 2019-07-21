package com.atsdev.moviecatalogueapi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        int loadingTime = 4000;
        new Handler().postDelayed(() -> {
            Intent main = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(main);
            finish();
        }, loadingTime);
    }
}
