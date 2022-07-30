package com.convertify.alkhaleej;

import android.content.Intent;
import android.gold.webview.codecanyon.com.webview.R;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import static com.convertify.alkhaleej.Config.SPLASH_TIMEOUT;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.splash_screen);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorWhite));
        getWindow().setStatusBarColor(getResources().getColor(R.color.colorWhite));

        final ImageView splash = findViewById(R.id.splash);
        //splash.setImageResource(R.mipmap.ic_launcher);
        splash.setImageResource(R.drawable.logo_alkhaleej);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class));
                SplashScreen.this.finish();
            }
        }, SPLASH_TIMEOUT);

    }
}
