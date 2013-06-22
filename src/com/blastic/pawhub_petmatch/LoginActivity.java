package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;


public class LoginActivity extends Activity {
	
	ImageButton btnLogin;

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);

	btnLogin = (ImageButton) findViewById(R.id.loginPawHubButton);
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}


public void onBtnPHLogin_Click(View v){ 
	//Intent i = new Intent(this,MatchSettingsActivity.class);
	Intent loginPHIntent = new Intent(this,MainActivity.class);
	startActivity(loginPHIntent);
}

}