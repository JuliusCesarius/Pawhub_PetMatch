package com.blastic.pawhub_petmatch;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.widget.TextView;

import com.blastic.utilities.ActionBarHandler;

public class MainTabsActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tabs_layout);

	 mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
	 
	    mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
	    mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Rate My Pet"),
	            RateMyPetActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("View My Ratings"),
	    		MyRatesActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Global Ratings"),
	    		GlobalRatesActivityFragment.class, null);
	    
	    //mTabHost.setCurrentTab(0);
	    
	    for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++) 
	    {
	        TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
	        tv.setTextColor(Color.rgb(152,30,72));
	        tv.setGravity(Gravity.CENTER);
	        if(mTabHost.getTabWidget().getChildAt(i).isSelected()){
		        mTabHost.getTabWidget().setStripEnabled(true);
		        mTabHost.getTabWidget().setRightStripDrawable(R.drawable.tab_strip_thin); 
	            mTabHost.getTabWidget().setLeftStripDrawable(R.drawable.tab_strip_thin);
	        }
	    } 
	    
	    ActionBarHandler.setActionBar(this);
	}
}