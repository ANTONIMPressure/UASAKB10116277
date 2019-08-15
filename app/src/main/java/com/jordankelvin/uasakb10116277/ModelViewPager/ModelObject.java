package com.jordankelvin.uasakb10116277.ModelViewPager;

import com.jordankelvin.uasakb10116277.R;

/*
    HARI    : Selasa, 21 Mei 2019
    NIM     : 10116277
    NAMA    : Jordan Kelvin ALyan Firdaus
    KELAS   : IF-7
 */

public enum ModelObject {

    GREEN(R.string.green, R.layout.view_green),
    Informasi(R.string.inforamasi, R.layout.view_informasi),
    Halaman(R.string.menu, R.layout.activity_main);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}