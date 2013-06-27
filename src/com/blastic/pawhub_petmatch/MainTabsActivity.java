package com.blastic.pawhub_petmatch;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Gravity;
import android.widget.TextView;

import com.blastic.utilities.ActionBarHandler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainTabsActivity extends FragmentActivity {

	private FragmentTabHost mTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.tabs_layout);
	ActionBarHandler.setActionBar(this);

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

	}
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
        case android.R.id.home:
            // do something useful
        	onBackPressed();
            return true;
        case R.id.action_profile:
	        Log.i("content action bar", "item 1 selected");
	        Intent intent = new Intent(this, EditUserActivity.class);
	        startActivity(intent);
	        return true;
		default:
			return(super.onOptionsItemSelected(item));
		}
	}
}