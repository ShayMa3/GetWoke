package com.example.sma51.getwoke;

import android.app.AlarmManager;
import android.app.TimePickerDialog;
import android.content.Context;
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
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class NavigationActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{

    public Fragment fragmentHF = new HomeFragment();
    final Fragment fragmentAF = new AlarmFragment();
    final Fragment fragmentPF = new ProfileFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragmentHF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, fragmentPF, "3").hide(fragmentPF).commit();
        fm.beginTransaction().add(R.id.main_container, fragmentAF, "2").hide(fragmentAF).commit();
        fm.beginTransaction().add(R.id.main_container,fragmentHF, "1").commit();
        //replace "main_container" with container_home, container_alarm, and container_profile?
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().hide(active).show(fragmentHF).commit();
                    active = fragmentHF;
                    return true;

                case R.id.navigation_alarms:
                    fm.beginTransaction().hide(active).show(fragmentAF).commit();
                    active = fragmentAF;
                    return true;

                case R.id.navigation_profile:
                    fm.beginTransaction().hide(active).show(fragmentPF).commit();
                    active = fragmentPF;
                    return true;
            }
            return false;
        }
    };


    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        //updateTimeText(c);
        //startAlarm(c);
        //first time
        TextView timeText = (TextView) findViewById(R.id.time_text);
        timeText.setText(getString(R.string.time_text, hourOfDay, minute));
        String timeReal = "" + hourOfDay + ": " + minute;


        Bundle bundle = new Bundle();
        bundle.putString("timeReal1", timeReal);
        AlarmFragment af = new AlarmFragment();
        af.setArguments(bundle);
    }

    public void updateTimeText(Calendar c){
        //displays time from calendar                     //gets only hours and minutes
        String timeTextHome = "Time: ";
        //timeTextHome += DateFormat.getTimeInstance(DateFormat.SHORT).format(c);
        Bundle bundleTime = new Bundle();
        bundleTime.putString("alarm time", timeTextHome);
        HomeFragment hf = new HomeFragment();
        hf.setArguments(bundleTime);

        //pass this string into homefragment to set the alarmTime textview
    }

    public void startAlarm(Calendar c){
        //AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }

}
