package com.omerfpekgoz.sayitahminuygulamasi;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.omerfpekgoz.sayitahminuygulamasi.R.color.colorGreen;

public class SonucActivity extends AppCompatActivity {

    private ImageView imgIfade;
    private TextView txtSonuc;
    private Button btnTekrarOyna;
    private TextView txtSayiTahmin;

    private Boolean sonuc;
    private Integer tahminSayi;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc_aktivity);

        imgIfade=findViewById(R.id.imgIfade);
        txtSonuc=findViewById(R.id.txtSonuc);
        btnTekrarOyna=findViewById(R.id.btnTekrarOyna);
        txtSayiTahmin=findViewById(R.id.txtSayiTahmin);

        sonuc=getIntent().getBooleanExtra("sonuc",false);
        tahminSayi=getIntent().getIntExtra("sayiTahmin",0);

        if (sonuc==true) {


            txtSonuc.setText("KAZANDINIZ");
            txtSonuc.setTextColor(colorGreen);
            imgIfade.setImageResource(R.drawable.gulensurat);

        }else{


            txtSonuc.setText("KAYBETTİNİZ");
            imgIfade.setImageResource(R.drawable.uzgunsurat);
            txtSayiTahmin.setText("Tahmin Etmeye Çalıştığınız Sayı: "+String.valueOf(tahminSayi));

        }


        btnTekrarOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucActivity.this,TahminActivity.class));
                finish();

            }
        });

    }
}
