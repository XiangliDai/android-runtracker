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
    private RunManager mRunManager;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mRunManager = RunManager.get(getActivity());
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
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRunManager.startLocationUpdates();
                updateUI();
            }
        });
        mStopButton = (Button) view.findViewById(R.id.run_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRunManager.stopLocationUpdates();
                updateUI();
            }
        });
        updateUI();
         return view;

    }

    private void updateUI() {
       boolean started = mRunManager.isTrackingRun();
        mStartButton.setEnabled(!started);
        mStopButton.setEnabled(started);
    }

}
