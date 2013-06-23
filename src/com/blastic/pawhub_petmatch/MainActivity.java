package com.blastic.pawhub_petmatch;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	ImageButton btnRate;
	ImageButton btnMatch;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnRate = (ImageButton) findViewById(R.id.btnRateAPet);
        btnMatch = (ImageButton) findViewById(R.id.btnPetMatch);
        try{
        	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
				ActionBar actionBar = getActionBar();
		        actionBar.setDisplayHomeAsUpEnabled(true);
        	 }
        }catch(Exception ex){
        	Log.e("version", ex.getMessage());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onBtnRate_Click(View v){
		//Intent i = new Intent(this,RateMyPetActivity.class);
    	Intent i = new Intent(this,MainTabsActivity.class);
		startActivity(i);
	}
	
	public void onBtnMatch_Click(View v){
		Intent i = new Intent(this,PetmatchActivity.class);
		startActivity(i);
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
        case android.R.id.home:
            // do something useful
        	Intent i = new Intent(this, LoginActivity.class);
        	startActivity(i);
            return(true);
        case R.id.action_edit_user:
	        Log.i("content action bar", "item 1 selected");
	        Intent intent = new Intent(this, EditUserActivity.class);
	        startActivity(intent);
	        return true;
		default:
			return(super.onOptionsItemSelected(item));
		}
	}
    
}
