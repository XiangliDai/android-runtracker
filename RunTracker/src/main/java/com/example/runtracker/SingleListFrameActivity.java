package com.example.runtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
/**
 * Created by xdai on 11/13/13.
 */
public abstract class SingleListFrameActivity extends SherlockFragmentActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm = getSupportFragmentManager();
        SherlockListFragment  fragment = (SherlockListFragment) fm.findFragmentById(R.id.fragment_container);

        if(fragment == null)  {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit();

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }

    protected abstract SherlockListFragment createFragment();
}
