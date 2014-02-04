package com.example.runtracker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * Created by xdai on 2/3/14.
 */
public class RunFragment extends SherlockFragment {
    private Button mStartButton, mStopButton;
    private TextView mStartedTextView, mLatitudeTextView, mLongitudeTextView, mAltitudeTextView, mDurationTextView;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public static RunFragment newInstance(){
        Bundle args = new Bundle();

        RunFragment runFragment = new RunFragment();
        runFragment.setArguments(args);

        return runFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_run, container,false);
        mStartedTextView = (TextView) view.findViewById(R.id.run_startedTextView);
        mLatitudeTextView= (TextView) view.findViewById(R.id.run_altitudeTextView);
        mLongitudeTextView = (TextView) view.findViewById(R.id.run_longitudeTextView);
        mAltitudeTextView = (TextView) view.findViewById(R.id.run_altitudeTextView);
        mDurationTextView = (TextView) view.findViewById(R.id.run_durationTextView);

        mStartButton = (Button) view.findViewById(R.id.run_startButton);
        mStopButton = (Button) view.findViewById(R.id.run_stopButton);
         return view;

    }

}
