package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

import com.blastic.utilities.ActionBarHandler;

public class MainTabsActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tabs_layout);

	 mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
	    mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
	    mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Rate a Pet"),
	            RateMyPetActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("View My Rates"),
	    		RateMyPetActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Global Rates"),
	    		RateMyPetActivityFragment.class, null);
	    
	    mTabHost.setCurrentTab(0);
	    
	    ActionBarHandler.setActionBar(this);
	}
}