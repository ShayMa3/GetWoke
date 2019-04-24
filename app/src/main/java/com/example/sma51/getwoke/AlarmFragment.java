package com.example.sma51.getwoke;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.Preconditions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmFragment extends Fragment implements View.OnClickListener {

    private Button saveAlarm;
    private EditText alarmTitle;


    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_alarm, container, false);

        saveAlarm = (Button) rootView.findViewById(R.id.save_alarm_button);
        Button openPicker = (Button) rootView.findViewById(R.id.open_picker_button);
        openPicker.setOnClickListener(this);
        saveAlarm.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.open_picker_button:
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getFragmentManager(), "time picker");
                break;

            case R.id.save_alarm_button:
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_container, HomeFragment);
                transaction.addToBackStack(null);

                transaction.commit();

        }
    }

    /*
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        TextView timeText = (TextView) getView().findViewById(R.id.time_text);
        timeText.setText(getString(R.string.time_text, hourOfDay, minute));
    }
    */
}
