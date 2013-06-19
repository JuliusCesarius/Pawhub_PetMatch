package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EditUserActivity extends Activity {

	ImageButton btnFinish;
	ImageView picUSer;

	String name = "";

	private static int TAKE_PICTURE = 1;
	private static int SELECT_PICTURE = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_user);

		btnFinish = (ImageButton) findViewById(R.id.btnEditAPet);
		ImageView picUSer = (ImageView) findViewById(R.id.userPicture);
		name = Environment.getExternalStorageDirectory() + "/DCIM/test.jpg";

		Log.i("file", name);
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

	

}
