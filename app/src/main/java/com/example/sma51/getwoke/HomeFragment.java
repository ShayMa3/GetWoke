package com.example.sma51.getwoke;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private TextView noAlarmText, noAlarmWelcome, yesAlarmWake, yesAlarmDay, alarmTime, alarmTitle;
    private Button wakeButton;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        Button wakeButton = (Button) rootView.findViewById(R.id.wake_up_button);
        TextView noAlarmText = (TextView) rootView.findViewById(R.id.no_alarm_text);
        TextView noAlarmWelcome = (TextView) rootView.findViewById(R.id.no_alarm_text_welcome);
        TextView yesAlarmWake = (TextView) rootView.findViewById(R.id.yes_alarm_text_wake);
        TextView yesAlarmDay = (TextView) rootView.findViewById(R.id.yes_alarm_text_day);
        TextView alarmTime = (TextView) rootView.findViewById(R.id.alarm_time_text);
        TextView alarmTitle = (TextView) rootView.findViewById(R.id.alarm_title_text);
        wakeButton.setOnClickListener(this);

        Bundle bundle = getArguments();


        //sets new alarm title & time from AlarmFragment
        if (bundle != null) {
            String title = bundle.getString("title");
            alarmTitle.setText(title);
            alarmTitle.setVisibility(View.VISIBLE);
            String time = bundle.getString("time");
            alarmTime.setText(time);
            alarmTime.setVisibility(View.VISIBLE);

            //sets description
            //if an alarm is set, make text say "WAKE UP to start your day"
            //else, say "Welcome! You have no alarms currently set", make "I'm Awake" button unclickable
            noAlarmWelcome.setVisibility(View.INVISIBLE);
            noAlarmText.setVisibility(View.INVISIBLE);
            yesAlarmWake.setVisibility(View.VISIBLE);
            yesAlarmDay.setVisibility(View.VISIBLE);
            wakeButton.setEnabled(true);

        }



        return rootView;
    }

    public void updateAlarmTitle(CharSequence newTitle){
        alarmTitle.setText(newTitle);
    }

    @Override
    public void onClick(View view) {
        //saveAlarm();
    }
}
