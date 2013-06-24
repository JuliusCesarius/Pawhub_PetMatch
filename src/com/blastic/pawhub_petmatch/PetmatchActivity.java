package com.blastic.pawhub_petmatch;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.blastic.utilities.ActionBarHandler;
import com.blastic.utilities.BaseActivity;
import com.blastic.utilities.Images;

public class PetmatchActivity extends BaseActivity {

	Button btnMatch;
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_petmatch);
		
		ActionBarHandler.setActionBar(this);
		Images.cropImage(R.drawable.pettorate, R.id.imgPetToRate, this);
		Images.cropImage(R.drawable.petask, R.id.imgAskPet, this);
		
		
		btnMatch = (Button) findViewById(R.id.btnMatch);
		
		
;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onBtnMatch_Click(View v)
	{
		Intent i = new Intent(this,PetmatchResult.class);
		startActivity(i);
	}
	
}
