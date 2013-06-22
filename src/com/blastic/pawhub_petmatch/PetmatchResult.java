package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;



public class PetmatchResult extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_petmatch_result);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.petmatch_result, menu);
		return true;
	}

}
