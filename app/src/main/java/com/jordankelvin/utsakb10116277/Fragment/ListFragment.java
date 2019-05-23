package com.jordankelvin.utsakb10116277.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jordankelvin.utsakb10116277.R;

/*
    HARI,TGL    : Rabu, 22 Mei 2019
    NIM         : 10116277
    NAMA        : Jordan Kelvin ALyan Firdaus
    KELAS       : IF-7
 */

public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }

}

