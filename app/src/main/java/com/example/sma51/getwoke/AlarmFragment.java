package com.example.sma51.getwoke;


import android.app.TimePickerDialog;
import android.content.Context;
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

    private Button buttonSaveAlarm;
    private EditText alarmTitle;
    private Bundle bundle;

    public AlarmFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_alarm, container, false);
        alarmTitle = (EditText) rootView.findViewById(R.id.alarm_title_edit_text);
        buttonSaveAlarm = (Button) rootView.findViewById(R.id.save_alarm_button);
        Button openPicker = (Button) rootView.findViewById(R.id.open_picker_button);
        openPicker.setOnClickListener(this);
        buttonSaveAlarm.setOnClickListener(this);
        bundle = getArguments();

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
                Bundle bundleTitle = new Bundle();
                if(bundle!=null){
                    String timeReal = bundle.getString("timeReal1");
                    bundleTitle.putString("timeReal", timeReal);
                }

                //get alarmTitle from editText
                String title = alarmTitle.getText().toString();
                bundleTitle.putString("title", title);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundleTitle);
                fragmentTransaction.replace(R.id.main_container, homeFragment);
                fragmentTransaction.commit();
        }
    }
}
