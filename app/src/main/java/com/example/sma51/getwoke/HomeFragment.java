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
public class HomeFragment extends Fragment {

    private TextView noAlarmText, alarmTime, alarmTitle;
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
        TextView alarmTime = (TextView) rootView.findViewById(R.id.alarm_time_text);
        TextView alarmTitle = (TextView) rootView.findViewById(R.id.alarm_title_text);

        //wakeButton.setOnClickListener(this);



        return rootView;
    }

}
