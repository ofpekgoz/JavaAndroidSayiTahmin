package com.omerfpekgoz.sayitahminuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {

    private TextView txtKalanHak;
    private TextView txtArtirAzalt;
    private EditText txtSayiGiriniz;
    private Button btnTahminEt;
    private int rastgeleSayi;
    private int sayac=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        txtKalanHak=findViewById(R.id.txtKalanHak);
        txtSayiGiriniz=findViewById(R.id.txtSayiGiriniz);
        txtArtirAzalt=findViewById(R.id.txtArtirAzalt);
        btnTahminEt=findViewById(R.id.btnTahminEt);

        Random r=new Random();
        rastgeleSayi=r.nextInt(101);
        Log.e("Sayı: ",String.valueOf(rastgeleSayi));

        btnTahminEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("mesaj",txtSayiGiriniz.getText().toString());
                if (txtSayiGiriniz.getText().toString().equals("")){
                    Toast.makeText(TahminActivity.this,"Lütfen Tahmini Sayı Giriniz...",Toast.LENGTH_SHORT).show();
                }
                int tahminiSayi=Integer.parseInt(txtSayiGiriniz.getText().toString());
                sayac--;


                    if (sayac!=0) {
                        if (tahminiSayi > rastgeleSayi) {
                            txtArtirAzalt.setText("Azalt");
                            txtKalanHak.setText("Kalan Hakkınız: " + sayac);
                        }  if (tahminiSayi < rastgeleSayi) {
                            txtArtirAzalt.setText("Arttır");
                            txtKalanHak.setText("Kalan Hakkınız: " + sayac);
                        }  if (tahminiSayi==rastgeleSayi){
                          Intent tahminIntent=new Intent(TahminActivity.this,SonucActivity.class);
                          tahminIntent.putExtra("sonuc",true);
                          startActivity(tahminIntent);
                          finish();
                          return;
                        }
                    }
                    else if(sayac<=0){

                        Intent tahminIntent=new Intent(TahminActivity.this,SonucActivity.class);
                        tahminIntent.putExtra("sonuc",false);
                        tahminIntent.putExtra("sayiTahmin",rastgeleSayi);
                        startActivity(tahminIntent);
                        finish();
                    }



                    txtSayiGiriniz.setText("");



            }
        });
    }
}
