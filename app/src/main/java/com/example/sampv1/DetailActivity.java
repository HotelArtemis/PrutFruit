package com.example.sampv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener {

    TextView datanama,datastokbarang,datatelepon,dataalamat;
    Button btncall, sharebt;
    ImageView datagambar;
    DarkModeSimpan darkmodesimpanan;

    public static String id,nama,telepon,gambar,stokbarang,alamattt;
    public static Double Lattitude,Lontitude;

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
        setContentView(R.layout.activity_detail);


        datanama=findViewById(R.id.tv_nama);
        datastokbarang=findViewById(R.id.tv_barang);
        datatelepon=findViewById(R.id.tv_tel);
        datagambar=findViewById(R.id.img_data);
        btncall=findViewById(R.id.btn_call);
        dataalamat=findViewById(R.id.tv_lamat);

        datanama.setText(nama);
        datastokbarang.setText(stokbarang);
        datatelepon.setText(telepon);
        dataalamat.setText(alamattt);
        Picasso.get().load(gambar).into(datagambar);


        btncall.setOnClickListener(this);

//share button
        sharebt=(Button)findViewById(R.id.tombol11);
        sharebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shared = new Intent(Intent.ACTION_SEND);
                shared.setType("text/plain");
                String bodyshare = "Share";
                String subshare = "bagikan kepada teman / sahabat";
                shared.putExtra(Intent.EXTRA_SUBJECT,bodyshare);
                shared.putExtra(Intent.EXTRA_TEXT,subshare);
                startActivity(Intent.createChooser(shared, "Gunakan Bagikan"));
            }
        });

//---------------
    }

    @Override
    public void onClick(View v) {
        Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+telepon));

        startActivity(call);
    }
}
