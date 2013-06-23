package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;



public class RateMyPetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate_my_pet);
		
		// llama el valor pasado por Globalrates
		Intent mIntent = getIntent();
		String varianleId = mIntent.getDataString();
		
		Log.i("PetID", varianleId);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rate_my_pet, menu);
		return true;
	}

}
