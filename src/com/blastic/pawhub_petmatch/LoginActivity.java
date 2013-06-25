package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blastic.utilities.ActionBarHandler;


public class LoginActivity extends Activity {
	
	private final String ENTER_USERNAME="Enter a username";
	private final String ENTER_PASSWORD="Enter password";
	
	Button btnLogin;
	

	@Override 
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_login);
	ActionBarHandler.hide(this);
	btnLogin = (Button) findViewById(R.id.loginPawHubButton);
	
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}


public void onBtnPHLogin_Click(View v){ 
	
	TextView user = (TextView) findViewById(R.id.txtUser);
	TextView password = (TextView) findViewById(R.id.txtPassword);
	
	if(user.getText().toString().equals("")){
		Toast.makeText(getApplicationContext(), ENTER_USERNAME, Toast.LENGTH_SHORT).show();
		return;
		}
	else if(password.getText().toString().equals("")){
		Toast.makeText(getApplicationContext(), ENTER_PASSWORD, Toast.LENGTH_SHORT).show();
		return;
	}
	
	
	Intent loginPHIntent = new Intent(this,MainActivity.class);
	startActivity(loginPHIntent);
}

}