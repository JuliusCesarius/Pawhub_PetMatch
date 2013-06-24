package com.blastic.pawhub_petmatch;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.blastic.utilities.ActionBarHandler;
import com.blastic.utilities.BaseActivity;

public class MainActivity extends BaseActivity {
	
	ImageButton btnRate;
	ImageButton btnMatch;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnRate = (ImageButton) findViewById(R.id.btnRateAPet);
        btnMatch = (ImageButton) findViewById(R.id.btnPetMatch);
        ActionBarHandler.setActionBar(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onBtnRate_Click(View v){
		//Intent i = new Intent(this,RateMyPetActivity.class);
    	Intent i = new Intent(this,GlobalRatesActivity.class);
		startActivity(i);
	}
	
	public void onBtnMatch_Click(View v){
		Intent i = new Intent(this,PetmatchActivity.class);
		startActivity(i);
	}
	
//	public boolean onOptionsItemSelected(MenuItem item){
//		switch (item.getItemId()) {
//        case android.R.id.home:
//            // do something useful
//        	Intent i = new Intent(this, LoginActivity.class);
//        	startActivity(i);
//            return true;
//        case R.id.action_profile:
//	        Log.i("content action bar", "item 1 selected");
//	        Intent intent = new Intent(this, EditUserActivity.class);
//	        startActivity(intent);
//	        return true;
//		default:
//			return(super.onOptionsItemSelected(item));
//		}
//	}
    
}
