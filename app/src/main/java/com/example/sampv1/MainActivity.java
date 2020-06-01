package com.example.sampv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ImageView ivMaps, Tentang, Belanja, Settingz;
    DarkModeSimpan darkmodesimpanan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //darkmode
        darkmodesimpanan = new DarkModeSimpan(this);
        if(darkmodesimpanan.loadWaktuMalam()==true){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);
        //======================================================

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //set
        ivMaps = findViewById(R.id.iv_button1);
        Tentang = findViewById(R.id.iv_button4);
        Belanja = findViewById(R.id.iv_button2);
        Settingz = findViewById(R.id.button5);

        //manggil
        ivMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        Tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  pindahtentang = new Intent(MainActivity.this, com.example.sampv1.Tentang.class);
                MainActivity.this.startActivity(pindahtentang);
            }
        });

        Settingz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindahsetting = new Intent(MainActivity.this, DevActivity.class);
                MainActivity.this.startActivity(pindahsetting);
            }
        });


        }

        public void buka (View view){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bigbasket.com/cl/fruits-vegetables/#!page=4"));
            startActivity(browserIntent);
        }
    }



