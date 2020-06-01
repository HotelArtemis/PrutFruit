package com.example.sampv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splashscreen extends AppCompatActivity {

    private final int panjang_splash=700;
    DarkModeSimpan darkmodesimpanan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        darkmodesimpanan = new DarkModeSimpan(this);
        if(darkmodesimpanan.loadWaktuMalam()==true){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent tampil = new Intent(Splashscreen.this, MainActivity.class);
                Splashscreen.this.startActivity(tampil);
                Splashscreen.this.finish();
            }
        }, panjang_splash);
    }
}
