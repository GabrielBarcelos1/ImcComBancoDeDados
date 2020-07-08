package com.example.imccombancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {
    private static final int TEMPO_DA_SPLASH_ART = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirlogin();
            }
        }, TEMPO_DA_SPLASH_ART);
    }

    private void abrirlogin() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
