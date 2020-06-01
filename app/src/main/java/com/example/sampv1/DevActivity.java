package com.example.sampv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.location.SettingInjectorService;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class DevActivity extends AppCompatActivity {

private Switch switchku;
DarkModeSimpan darkmodesimpanan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

    darkmodesimpanan = new DarkModeSimpan(this);
        if(darkmodesimpanan.loadWaktuMalam()==true){
            setTheme(R.style.darktheme);
        }
        else setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);

        switchku=findViewById(R.id.switchmu);
        if (darkmodesimpanan.loadWaktuMalam()==true){
            switchku.setChecked(true);
        }
        switchku.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    darkmodesimpanan.setNightModeState(true);
                    restartApp();
                }
                else {
                    darkmodesimpanan.setNightModeState(false);
                    restartApp();
                }
            }
        });
    }
    public  void restartApp(){
        Intent i = new Intent(getApplicationContext(),DevActivity.class);
        startActivity(i);
        finish();
    }
}
