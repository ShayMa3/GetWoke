package com.example.sma51.getwoke;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    //private TextView mTextMessage;
    final Fragment fragment1 = new HomeFragment();
    final Fragment fragment2 = new AlarmFragment();
    final Fragment fragment3 = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container,fragment1, "1").commit();
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    //mTextMessage.setText(R.string.title_home);
                    return true;

                case R.id.navigation_alarms:
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    //mTextMessage.setText(R.string.title_alarms);
                    return true;

                case R.id.navigation_profile:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    //mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };


}
