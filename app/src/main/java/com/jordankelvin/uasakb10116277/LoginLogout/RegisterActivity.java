package com.jordankelvin.uasakb10116277.LoginLogout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.jordankelvin.uasakb10116277.LoginLogout.Preferences;
import com.jordankelvin.uasakb10116277.R;

/*
    HARI,TGL    : Kamis, 8 Agustus 2019
    NIM         : 10116277
    NAMA        : Jordan Kelvin ALyan Firdaus
    KELAS       : IF-7
 */

public class RegisterActivity extends AppCompatActivity {

    private EditText mViewUser, mViewPassword, mViewRepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mViewUser =findViewById(R.id.et_emailSignup);
        mViewPassword =findViewById(R.id.et_passwordSignup);
        mViewRepassword =findViewById(R.id.et_passwordSignup2);


        mViewRepassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    razia();
                    return true;
                }
                return false;
            }
        });


        findViewById(R.id.button_signupSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razia();
            }
        });
    }


    private void razia(){
        mViewUser.setError(null);
        mViewPassword.setError(null);
        mViewRepassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        String repassword = mViewRepassword.getText().toString();
        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();


        if (TextUtils.isEmpty(user)){
            mViewUser.setError("Masukkan Username");
            fokus = mViewUser;
            cancel = true;
        }else if(cekUser(user)){
            mViewUser.setError("Username telah ada");
            fokus = mViewUser;
            cancel = true;
        }

        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("Masukkan Password");
            fokus = mViewPassword;
            cancel = true;
        }else if (!cekPassword(password,repassword)){
            mViewRepassword.setError("Password telah ada");
            fokus = mViewRepassword;
            cancel = true;
        }

        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setRegisteredUser(getBaseContext(),user);
            Preferences.setRegisteredPass(getBaseContext(),password);
            finish();
        }
    }


    private boolean cekPassword(String password, String repassword){
        return password.equals(repassword);
    }


    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}

