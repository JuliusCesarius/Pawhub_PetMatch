package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.blastic.utilities.ActionBarHandler;

public class SplashScreenActivity extends Activity {
    
	private final int SPLASH_DISPLAY_LENGHT = 2000;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		
		ActionBarHandler.hide(this);

	 new Handler().postDelayed(new Runnable(){
         @Override
         public void run() {
             Intent mainIntent = new Intent(SplashScreenActivity.this,LoginActivity.class);
             SplashScreenActivity.this.startActivity(mainIntent);
             SplashScreenActivity.this.finish();
         }
     }, SPLASH_DISPLAY_LENGHT);
 }
}
