package com.blastic.pawhub_petmatch;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

import com.blastic.utilities.Images;

public class PetmatchResult extends Activity {

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_petmatch_result);
		
		ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
		
		Images.cropImage(R.drawable.bigcirclepet, R.id.imgPet, this);
		Images.cropImage(R.drawable.cocker, R.id.imgCorner, this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.petmatch_result, menu);
		return true;
	}

}
