package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class EditPetActivity extends Activity {
	
	ImageButton btnFinish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_pet);
		
		btnFinish = (ImageButton) findViewById(R.id.btnRateAPet);
		  
		Spinner spinnerType = (Spinner) findViewById(R.id.spinEditType);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.editType_array, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerType.setAdapter(adapterType); 
		
		Spinner spinnerBreed = (Spinner) findViewById(R.id.spinEditBreed);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterBreed = ArrayAdapter.createFromResource(this, R.array.editBreed_array, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		adapterBreed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerBreed.setAdapter(adapterBreed); 

	} 
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_pet, menu);
		return true;
	}
	
	public void onBtnFinish_Click(View v) {
		Intent i = new Intent(this, RateMyPetActivity.class);
		startActivity(i);
	}

}
