package com.jordankelvin.uasakb10116277.RealmD;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jordankelvin.uasakb10116277.R;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/*
    HARI    : Selasa, 13 Agustus 2019
    NIM     : 10116277
    NAMA    : Jordan Kelvin ALyan Firdaus
    KELAS   : IF-7
 */

public class DaftarMahasiswa extends AppCompatActivity implements View.OnClickListener {
    Button btnSimpan, btnTampil;
    EditText nim, nama;
    String sNama;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    MahasiswaModel mahasiswaModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);


        btnSimpan = findViewById(R.id.btnSimpan);
        btnTampil = findViewById(R.id.btnTampil);
        nim = findViewById(R.id.nim);
        nama = findViewById(R.id.nama);


        Realm.init(DaftarMahasiswa.this);
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btnSimpan.setOnClickListener(this);
        btnTampil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnSimpan){
            sNim = Integer.parseInt(nim.getText().toString());
            sNama = nama.getText().toString();

            if (!sNim.equals("") && !sNama.isEmpty()){
                mahasiswaModel = new MahasiswaModel();
                mahasiswaModel.setNim(sNim);
                mahasiswaModel.setNama(sNama);

                realmHelper = new RealmHelper(realm);
                realmHelper.save(mahasiswaModel);

                Toast.makeText(DaftarMahasiswa.this, "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                nim.setText("");
                nama.setText("");
            }else {
                Toast.makeText(DaftarMahasiswa.this, "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
            }
        }else if (v == btnTampil){
            startActivity(new Intent(DaftarMahasiswa.this, MahasiswaActivity.class));
        }
    }
}
