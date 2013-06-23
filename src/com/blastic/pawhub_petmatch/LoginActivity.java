package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


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
	
	TextView user = (TextView) findViewById(R.id.txtUser);
	TextView password = (TextView) findViewById(R.id.txtPassword);
	
	if(user.getText().toString().equals("")){
		Toast.makeText(getApplicationContext(), "Enter a username", Toast.LENGTH_SHORT).show();
		return;
		}
	else if(password.getText().toString().equals("")){
		Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
		return;
	}
	
	
	Intent loginPHIntent = new Intent(this,MainActivity.class);
	startActivity(loginPHIntent);
}

}