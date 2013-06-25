package com.blastic.pawhub_petmatch;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blastic.utilities.ActionBarHandler;
import com.blastic.utilities.BaseActivity;
import com.blastic.utilities.Images;

public class PetmatchResult extends BaseActivity {
	
	private final String FOLLOWING="Following";
	private final String SAY_HI="You said 'Hi' to Rocko";
	

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_petmatch_result);
        
		ActionBarHandler.setActionBar(this);
        
		Images.cropImageCorner(R.drawable.big_rocko, R.id.imgPetResult, this);
		Images.cropImage(R.drawable.cocker, R.id.imgCorner, this);
		
		Button follow = (Button) findViewById(R.id.btnFollow);
		follow.getBackground().setColorFilter(Color.rgb(151, 29, 71), PorterDuff.Mode.SRC_ATOP);
		
		Button sayHi = (Button) findViewById(R.id.btnSayHi);
		sayHi.getBackground().setColorFilter(Color.rgb(74, 188, 206), PorterDuff.Mode.SRC_ATOP);
		
		TextView textView =(TextView) findViewById(R.id.txtRateNumber);
		textView.getBackground().setColorFilter(Color.rgb(74, 188, 206), PorterDuff.Mode.SRC_ATOP);
		
		findViewById(R.id.dataPetLayout).getBackground().setColorFilter(Color.rgb(255, 255, 255), PorterDuff.Mode.SRC_ATOP);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	public void onClickFollow(View v)
	{
		Toast.makeText(getApplicationContext(), FOLLOWING, Toast.LENGTH_SHORT).show();
	}
	
	public void onClickSayHi(View v)
	{
		Toast.makeText(getApplicationContext(), SAY_HI, Toast.LENGTH_SHORT).show();	
	}

}
