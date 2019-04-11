package com.example.sma51.getwoke;


import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.util.Preconditions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlarmFragment extends Fragment{


    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_alarm, container, false);


        Button openPicker = (Button) rootView.findViewById(R.id.open_picker_button);
        openPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getFragmentManager(), "time picker");
            }
        });

        return rootView;
    }

    /*
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        TextView timeText = (TextView) getView().findViewById(R.id.time_text);
        timeText.setText(getString(R.string.time_text, hourOfDay, minute));
    }
    */
}
