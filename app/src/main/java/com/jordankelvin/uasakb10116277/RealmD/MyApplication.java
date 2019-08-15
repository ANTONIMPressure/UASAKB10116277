package com.jordankelvin.uasakb10116277.RealmD;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/*
    HARI    : Selasa, 13 agustus 2019
    NIM     : 10116277
    NAMA    : Jordan Kelvin ALyan Firdaus
    KELAS   : IF-7
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("mahasiswa.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
