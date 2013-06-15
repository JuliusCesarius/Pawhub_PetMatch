package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RateMyPetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate_my_pet);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rate_my_pet, menu);
		return true;
	}

}
