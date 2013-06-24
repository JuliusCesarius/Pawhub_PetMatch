package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;

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
	    		MyRatesActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Global Rates"),
	    		GlobalRatesActivityFragment.class, null);
	}
}