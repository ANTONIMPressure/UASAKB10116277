package com.jordankelvin.utsakb10116277;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.jordankelvin.utsakb10116277.Fragment.AccountFragment;
import com.jordankelvin.utsakb10116277.Fragment.ContactFragment;
import com.jordankelvin.utsakb10116277.Fragment.ListFragment;
import com.jordankelvin.utsakb10116277.ModelViewPager.CustomPagerAdapter;

/*
    HARI    : Rabu
    NIM     : 10116277
    NAMA    : Jordan Kelvin ALyan Firdaus
    KELAS   : IF-7
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new CustomPagerAdapter(this));

        loadFragment(new AccountFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.account_menu:
                fragment = new AccountFragment();
                break;
            case R.id.contact_menu:
                fragment = new ContactFragment();
                break;
            case R.id.list_menu:
                fragment = new ListFragment();
                break;
        }
        return loadFragment(fragment);
    }
    public void BukaFb (View view){
        String url = "https://www.facebook.com/jordankelvin";
        Intent openfb = new Intent(Intent.ACTION_VIEW);
        openfb.setData(Uri.parse(url));
        startActivity(openfb);
    }

    public void BukaIg (View view){
        String url = "https://www.instagram.com/jordankvn";
        Intent openig = new Intent(Intent.ACTION_VIEW);
        openig.setData(Uri.parse(url));
        startActivity(openig);
    }

    public void Call(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:0895337099358"));
        startActivity(intent);
    }

    public void BukaGmail (View view) {
        String url = "mailto:jordankelvin129@gmail.com";
        Intent opengmail = new Intent(Intent.ACTION_VIEW);
        opengmail.setData(Uri.parse(url));
        startActivity(opengmail);
    }
}
