package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	ImageButton btnRate;
	ImageButton btnMatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnRate = (ImageButton) findViewById(R.id.btnRateAPet);
        btnMatch = (ImageButton) findViewById(R.id.btnPetMatch);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onBtnRate_Click(View v){
		//Intent i = new Intent(this,RateMyPetActivity.class);
    	Intent i = new Intent(this,EditPetActivity.class);
		startActivity(i);
	}
	
	public void onBtnMatch_Click(View v){
		Intent i = new Intent(this,MatchSettingsActivity.class);
		startActivity(i);
	}
    
}
