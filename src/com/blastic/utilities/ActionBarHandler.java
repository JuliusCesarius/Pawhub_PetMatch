package com.blastic.utilities;

import com.blastic.pawhub_petmatch.R;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;

public final class ActionBarHandler {

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public static void setActionBar(Activity activity){
		 try{
        	 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
				ActionBar actionBar = activity.getActionBar();
		        actionBar.setDisplayHomeAsUpEnabled(true);
		        actionBar.setBackgroundDrawable((Drawable)activity.getResources().getDrawable(R.drawable.gradient_purple));
		        actionBar.setDisplayShowTitleEnabled(false);
        	 }
        }catch(Exception ex){
        	Log.e("version", ex.getMessage());
        }
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public static void hide(Activity activity)
	{
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
			ActionBar actionBar = activity.getActionBar();
			actionBar.hide();
		}
	}
}
