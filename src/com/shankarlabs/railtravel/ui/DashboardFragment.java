package com.shankarlabs.railtravel.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.shankarlabs.railtravel.R;

public class DashboardFragment extends Fragment
{
	private boolean mDualPane;
	private int curPane2Fragment = R.id.pnrstatus_fragment; // This is the standard pane2 fragment we load
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
	{
        super.onCreate(savedInstanceState);
    }
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.dashboard_fragment, container, false);
        
        /*
        // Initialize all the buttons
        Button reserveTicketBtn = (Button) fragmentView.findViewById(R.id.reserveticket);
        Button pnrStatusBtn = (Button) fragmentView.findViewById(R.id.pnrstatus);
        Button scheduleBtn = (Button) fragmentView.findViewById(R.id.schedule);
        Button availabilityBtn = (Button) fragmentView.findViewById(R.id.availability);
        Button placeholder5Btn = (Button) fragmentView.findViewById(R.id.placeholder5);
        
        reserveTicketBtn.setOnClickListener(reserveTicketBtnClickListener);
        pnrStatusBtn.setOnClickListener(pnrStatusBtnClickListener);
        scheduleBtn.setOnClickListener(scheduleBtnClickListener);
        availabilityBtn.setOnClickListener(availabilityBtnClickListener);
        placeholder5Btn.setOnClickListener(placeholder5BtnClickListener);
        */ 
        
        return fragmentView;
    }
	
	@Override
    public void onActivityCreated(Bundle savedInstanceState)
	{
        super.onActivityCreated(savedInstanceState);

        View dashboardView = getActivity().findViewById(R.id.dashboard_fragment);
        
        // Initialize all the buttons
        Button reserveTicketBtn = (Button) dashboardView.findViewById(R.id.reserveticket);
        Button pnrStatusBtn = (Button) dashboardView.findViewById(R.id.pnrstatus);
        Button scheduleBtn = (Button) dashboardView.findViewById(R.id.schedule);
        Button availabilityBtn = (Button) dashboardView.findViewById(R.id.availability);
        Button placeholder5Btn = (Button) dashboardView.findViewById(R.id.placeholder5);
        
        reserveTicketBtn.setOnClickListener(reserveTicketBtnClickListener);
        pnrStatusBtn.setOnClickListener(pnrStatusBtnClickListener);
        scheduleBtn.setOnClickListener(scheduleBtnClickListener);
        availabilityBtn.setOnClickListener(availabilityBtnClickListener);
        placeholder5Btn.setOnClickListener(placeholder5BtnClickListener);
        
        // Get pane2 for future use
        View pane2 = getActivity().findViewById(R.id.pane2_fragment);
        mDualPane = pane2 != null && pane2.getVisibility() == View.VISIBLE;
        
        // Programatically add a fragment to pane2 so the space is not empty
        if (mDualPane)
		{
			// We have two panes. Update Fragment
            // 
			Fragment pnrStatusFragment = new PNRStatusFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.pane2_fragment, pnrStatusFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            // ft.addToBackStack(null); // Dont commit because there's nothing to go back to
            ft.commit();
        }
    }
	
	OnClickListener reserveTicketBtnClickListener = new OnClickListener()
				{
					@Override
					public void onClick(View arg0)
					{
						Toast.makeText(getActivity(), "Reserving Ticket", Toast.LENGTH_SHORT).show();
					}
				};
	
	OnClickListener pnrStatusBtnClickListener = new OnClickListener()
				{
					@Override
					public void onClick(View arg0)
					{
						Toast.makeText(getActivity(), "Getting PNR Status", Toast.LENGTH_SHORT).show();

						// Update fragment or load the new Activity
						if (mDualPane)
						{
							// We have two panes. Update Fragment
			                // 
							Fragment pnrStatusFragment = new PNRStatusFragment();
			                FragmentTransaction ft = getFragmentManager().beginTransaction();
			                ft.replace(R.id.pane2_fragment, pnrStatusFragment);
			                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			                ft.addToBackStack(null);
			                ft.commit();
			            }
				        else
				        {
				            Intent intent = new Intent();
				            intent.setClass(getActivity(), PNRStatusActivity.class);
				            intent.putExtra("test", 24);
				            startActivity(intent);
				        }
					}
				};

	OnClickListener scheduleBtnClickListener = new OnClickListener()
				{
					@Override
					public void onClick(View arg0)
					{
						Toast.makeText(getActivity(), "Checking Scedule", Toast.LENGTH_SHORT).show();
					}
				};

	OnClickListener availabilityBtnClickListener = new OnClickListener()
				{
					@Override
					public void onClick(View arg0)
					{
						Toast.makeText(getActivity(), "Checking Availability", Toast.LENGTH_SHORT).show();
						
						// Update fragment or load the new Activity
						if (mDualPane)
						{
							// We have two panes. Update Fragment
			                // 
							Fragment availabilityFragment = new AvailabilityFragment();
			                FragmentTransaction ft = getFragmentManager().beginTransaction();
			                ft.replace(R.id.pane2_fragment, availabilityFragment);
			                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			                ft.addToBackStack(null);
			                ft.commit();
			            }
				        else
				        {
				            Intent intent = new Intent();
				            intent.setClass(getActivity(), AvailabilityActivity.class);
				            intent.putExtra("test", 23);
				            startActivity(intent);
				        }
					}
				};

	OnClickListener placeholder5BtnClickListener = new OnClickListener()
				{
					@Override
					public void onClick(View arg0)
					{
						Toast.makeText(getActivity(), "Placeholder 5 clicked", Toast.LENGTH_SHORT).show();
					}
				};

	@Override
    public void onPause() 
	{
        super.onPause();
    }
	
	
}
