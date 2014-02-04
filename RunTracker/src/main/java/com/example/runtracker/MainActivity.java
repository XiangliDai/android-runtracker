package com.example.runtracker;

import com.actionbarsherlock.app.SherlockFragment;

public class MainActivity extends SingleFrameActivity {



    @Override
    protected SherlockFragment createFragment() {
        return RunFragment.newInstance();

    }

}
