package com.blastic.utilities;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import com.blastic.pawhub_petmatch.EditUserActivity;
import com.blastic.pawhub_petmatch.R;

public class BaseActivity extends Activity {
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
        case android.R.id.home:
            // do something useful
        	onBackPressed();
            return true;
        case R.id.action_profile:
	        Log.i("content action bar", "item 1 selected");
	        Intent intent = new Intent(this, EditUserActivity.class);
	        startActivity(intent);
	        return true;
		default:
			return(super.onOptionsItemSelected(item));
		}
	}

}
