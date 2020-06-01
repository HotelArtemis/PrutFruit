package com.example.sampv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;

public class Tentang extends AppCompatActivity {

    DarkModeSimpan darkmodesimpanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        darkmodesimpanan = new DarkModeSimpan(this);
        if(darkmodesimpanan.loadWaktuMalam()==true){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
    }
}
