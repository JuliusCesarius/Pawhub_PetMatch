package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;




public class MatchSettingsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_match_settings);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.match_settings, menu);
		return true;
	}

}
