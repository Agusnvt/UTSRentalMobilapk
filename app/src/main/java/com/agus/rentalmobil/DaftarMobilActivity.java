package com.agus.rentalmobil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DaftarMobilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_mobil);
    }

    public void hal_sewa(View view) {
        Intent intent =new Intent(DaftarMobilActivity.this, SewaMobilActivity.class);
        startActivity(intent);
    }
}