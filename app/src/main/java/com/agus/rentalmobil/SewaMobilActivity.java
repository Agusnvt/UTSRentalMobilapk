package com.agus.rentalmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SewaMobilActivity extends AppCompatActivity {
    int harga_sewa_mobil,jml_lmsw,ttl_hargasewa,jml_uang;
    String s_nama;

    Spinner ad_listmobil;
    TextView harga_mobil;
    EditText lama_sewa,uangbayar,nama_penyewa;


    String list_mobil[] = {"Toyota Avansa","Daihatsu Xenia","Mitsubisi Pajero","Toyota Fortuner"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_mobil);
        nama_penyewa = findViewById(R.id.nama_penyewa);
        ad_listmobil = findViewById(R.id.ad_listmobil);
        harga_mobil = findViewById(R.id.harga_mobil);
        lama_sewa = findViewById(R.id.lama_sewa);
        uangbayar = findViewById(R.id.uangbayar);

        ArrayAdapter ad_mbl = new ArrayAdapter(SewaMobilActivity.this,R.layout.support_simple_spinner_dropdown_item,list_mobil);
        ad_listmobil.setAdapter(ad_mbl);


    }

    public void tmbl_OK (View view) {
        jml_lmsw= Integer.parseInt(lama_sewa.getText().toString());
        s_nama = nama_penyewa.getText().toString();


        if(ad_listmobil.getSelectedItem().toString()=="Toyota Avansa"){
            harga_sewa_mobil = 300000;
            ttl_hargasewa = jml_lmsw * harga_sewa_mobil;
            harga_mobil.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listmobil.getSelectedItem().toString() == "Daihatsu Xenia"){
            harga_sewa_mobil = 350000;
            ttl_hargasewa = jml_lmsw * harga_sewa_mobil;
            harga_mobil.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listmobil.getSelectedItem().toString() == "Mitsubisi Pajero"){
            harga_sewa_mobil = 600000;
            ttl_hargasewa = jml_lmsw * harga_sewa_mobil;
            harga_mobil.setText(Integer.toString(ttl_hargasewa));
        } else if (ad_listmobil.getSelectedItem().toString() == "Toyota Fortuner"){
            harga_sewa_mobil = 700000;
            ttl_hargasewa = jml_lmsw * harga_sewa_mobil;
            harga_mobil.setText(Integer.toString(ttl_hargasewa));
        }

    }

    public void tombol_sewa2(View view) {
        jml_uang = Integer.parseInt(uangbayar.getText().toString());
        if (jml_uang < ttl_hargasewa) {
            Toast.makeText(this, "Uang Kurang", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(SewaMobilActivity.this,StrukActivity.class);

            intent.putExtra("nama",s_nama);
            intent.putExtra("mobil",ad_listmobil.getSelectedItem().toString());
            intent.putExtra("lama",jml_lmsw);
            intent.putExtra("total",ttl_hargasewa);
            intent.putExtra("uang",jml_uang);
            intent.putExtra("kembalian",jml_uang-ttl_hargasewa);

            startActivity(intent);
        }
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(SewaMobilActivity.this,MainActivity.class);
        startActivity(intent);
    }
}