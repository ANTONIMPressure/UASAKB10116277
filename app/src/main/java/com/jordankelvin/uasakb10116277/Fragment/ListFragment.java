package com.jordankelvin.uasakb10116277.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jordankelvin.uasakb10116277.R;
import com.jordankelvin.uasakb10116277.RealmD.DetailActivity;

/*
    HARI,TGL    : Kamis, 15 Agustus 2019
    NIM         : 10116277
    NAMA        : Jordan Kelvin ALyan Firdaus
    KELAS       : IF-7
 */

public class ListFragment extends Fragment {


    Button btnSimpan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_daftar, container, false);
        return view;
    }



}

