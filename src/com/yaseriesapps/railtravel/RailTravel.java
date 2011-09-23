package com.yaseriesapps.railtravel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;

public class RailTravel extends Activity 
{
	private final String LOGTAG = "RailTravel";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.d(LOGTAG, "Loaded main screen");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        
        Log.d(LOGTAG, "Inflated menu");
        
        return true;
    }
}