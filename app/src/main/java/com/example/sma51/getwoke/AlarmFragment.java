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
    private AlarmFragmentListener listener;

    public interface AlarmFragmentListener{
        void onInputASent(CharSequence input);
    }

    public AlarmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_alarm, container, false);

        buttonSaveAlarm = (Button) rootView.findViewById(R.id.save_alarm_button);
        alarmTitle = (EditText) rootView.findViewById(R.id.alarm_title_edit_text);
        Button openPicker = (Button) rootView.findViewById(R.id.open_picker_button);

        openPicker.setOnClickListener(this);
        buttonSaveAlarm.setOnClickListener(this);

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

                //get alarmTitle from editText
                String title = alarmTitle.getText().toString();
                Bundle bundle2 = new Bundle();
                bundle2.putString("title", title);

                //get time from timePicker in NavigationActivity
                Bundle bundle1 = getArguments();
                if(bundle1 != null){
                    int hour = getArguments().getInt("hour");
                    int minute = getArguments().getInt("minute");
                    String time = "put time here" + hour;
                    bundle2.putString("time", time);
                }


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle2);
                fragmentTransaction.replace(R.id.main_container, homeFragment);
                fragmentTransaction.commit();

                //CharSequence input = alarmTitle.getText();
                //listener.onInputASent(input);

                //FragmentTransaction transaction = getFragmentManager().beginTransaction();
                //transaction.replace(R.id.main_container, HomeFragment);
                //transaction.addToBackStack(null);

                //transaction.commit();

        }
    }

    public void updateEditText(CharSequence newText){
        alarmTitle.setText(newText);
    }

    //when the fragment attaches to the activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //checks if the activity implements the interface
        if(context instanceof AlarmFragmentListener){
            listener = (AlarmFragmentListener) context;
        }
        else{
            throw new RuntimeException(context.toString()
            + " must implement AlarmFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    /*
    @Override
    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
        TextView timeText = (TextView) getView().findViewById(R.id.time_text);
        timeText.setText(getString(R.string.time_text, hourOfDay, minute));
    }
    */
}
