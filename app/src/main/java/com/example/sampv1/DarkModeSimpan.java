package com.example.sampv1;

import android.content.Context;
import android.content.SharedPreferences;

public class DarkModeSimpan {
    SharedPreferences simpandarkmode;
    public DarkModeSimpan(Context context) {
        simpandarkmode = context.getSharedPreferences("filename",Context.MODE_PRIVATE);
    }
    //etode ini akan menyimpan mode malam
    public void setNightModeState(Boolean state){
        SharedPreferences.Editor editor = simpandarkmode.edit();
        editor.putBoolean("NightMode",state);
        editor.commit();
    }
     //metode ini akan me-load waktu modemalam
    public Boolean loadWaktuMalam (){
        Boolean state = simpandarkmode.getBoolean("NightMode",false);
        return state;
    }
}
