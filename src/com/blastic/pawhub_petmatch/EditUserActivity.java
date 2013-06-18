package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class EditUserActivity extends Activity {
	
	ImageButton btnFinish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_user);
		
		btnFinish = (ImageButton) findViewById(R.id.btnEditAPet);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_user, menu);
		return true;
	}
	
	
	
	public void onBtnFinish_Click(View v) {
		
		Intent editPetIntend = new Intent(this, RateMyPetActivity.class);
		startActivity(editPetIntend);
	}
	
public void onBtnMore_Click(View v) {
		
		Intent morePetsIntend = new Intent(this, EditPetActivity.class);
		startActivity(morePetsIntend);
	}

public void onBtnUserPic_Click(View v) {
	
	Intent pickIntent = new Intent();
	pickIntent.setType("image/*");
	pickIntent.setAction(Intent.ACTION_GET_CONTENT);

	Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

	String pickTitle = "Select or take a new Picture"; // Or get from strings.xml
	Intent chooserIntent = Intent.createChooser(pickIntent, pickTitle);
	chooserIntent.putExtra
	(
	  Intent.EXTRA_INITIAL_INTENTS, 
	  new Intent[] { takePhotoIntent }
	);
	
	startActivityForResult(chooserIntent, -1);
}

}
