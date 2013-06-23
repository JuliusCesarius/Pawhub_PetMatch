package com.blastic.pawhub_petmatch;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TableRow;

import com.blastic.utilities.Images;

public class DetailsRate extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_rate);
		Bitmap bitmap = Images.GetBitmapClippedCircle(BitmapFactory.decodeResource(getResources(),R.drawable.greenbackground));
		Drawable drawable = new BitmapDrawable(getResources(),Images.GetBitmapClippedCircle(bitmap));
		TableRow tableRow = (TableRow)findViewById(R.id.valueRate);
		tableRow.setBackground(drawable);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details_rate, menu);
		return true;
	}

}
