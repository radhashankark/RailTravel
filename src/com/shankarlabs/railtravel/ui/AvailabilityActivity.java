package com.shankarlabs.railtravel.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import com.example.android.actionbarcompat.ActionBarFragmentActivity;
import com.shankarlabs.railtravel.R;

public class AvailabilityActivity extends ActionBarFragmentActivity
{

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.availability);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // MenuInflater menuInflater = getMenuInflater();
        // menuInflater.inflate(R.menu.main, menu);

        // Calling super after populating the menu is necessary here to ensure that the
        // action bar helpers have a chance to handle this event.
        return super.onCreateOptionsMenu(menu);
    }
}
