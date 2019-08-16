package com.jordankelvin.uasakb10116277.RealmD;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/*
    HARI    : Selasa, 13 Agustus 2019
    NIM     : 10116277
    NAMA    : Jordan Kelvin ALyan Firdaus
    KELAS   : IF-7
 */

public class RealmHelper {

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }
    public void save(final MahasiswaModel mahasiswaModel){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(MahasiswaModel.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    mahasiswaModel.setId(nextId);
                    MahasiswaModel model = realm.copyToRealm(mahasiswaModel);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }


    public List<MahasiswaModel> getAllMahasiswa(){
        RealmResults<MahasiswaModel> results = realm.where(MahasiswaModel.class).findAll();
        return results;
    }

    public void update(final Integer id, final Integer nim, final String nama){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                MahasiswaModel model = realm.where(MahasiswaModel.class)
                        .equalTo("id", id)
                        .findFirst();
                model.setNim(nim);
                model.setNama(nama);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    public void delete(Integer id){
        final RealmResults<MahasiswaModel> model = realm.where(MahasiswaModel.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                model.deleteFromRealm(0);
            }
        });
    }

}