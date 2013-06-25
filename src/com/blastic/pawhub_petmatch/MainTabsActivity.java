package com.blastic.pawhub_petmatch;

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
	    mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator("Rate a Pet"),
	            RateMyPetActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("View My Rates"),
	    		MyRatesActivityFragment.class, null);
	    mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("Global Rates"),
	    		GlobalRatesActivityFragment.class, null);
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