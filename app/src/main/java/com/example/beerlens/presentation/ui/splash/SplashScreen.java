package com.example.beerlens.presentation.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.beerlens.domain.tools.Tools;
import com.example.beerlens.presentation.ui.home.Home;
import com.example.beerlens.presentation.ui.login.Login;
import com.example.beerlens.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        launchSplash();

    }

    private void launchSplash() {
        new Handler().postDelayed(() -> {
            if (Tools.getUserPreferences(this).getUserName() != ""){
                startActivity(new Intent(SplashScreen.this, Home.class));

            }else{
                startActivity(new Intent(SplashScreen.this, Login.class));
            }

            finish();
        },2000);
    }
}