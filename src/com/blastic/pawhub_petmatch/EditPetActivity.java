package com.blastic.pawhub_petmatch;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.blastic.adapters.SpinKindAdapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.Kind;

public class EditPetActivity extends Activity {

	GenericAsyncTask<Kind> getKindsAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_pet);

		String urlString = "http://wskrs.com/profile/getkinds";
		getKindsAsyncTask = new GetKindTask(Kind.class);
		getKindsAsyncTask.execute(urlString);

		Spinner spinnerBreed = (Spinner) findViewById(R.id.spinEditBreed);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapterBreed = ArrayAdapter
				.createFromResource(this, R.array.editBreed_array,
						android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapterBreed
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
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
		Intent i = new Intent(this, GlobalRatesActivity.class);
		startActivity(i);
	}

	public void onspinEditType_Click(View view) {
		View spinner = view;
	}

	private class GetKindTask extends GenericAsyncTask<Kind> {

		protected GetKindTask(Class<Kind> tipo) {
			super(tipo);
		}

		@Override
		protected void onPostExecute(ArrayList<Kind> elements) {
			final Spinner spinnerType = (Spinner) findViewById(R.id.spinEditType);
			SpinKindAdapter kindAdapter = new SpinKindAdapter(
					EditPetActivity.this, android.R.layout.simple_spinner_item,
					elements.toArray(new Kind[elements.size()]));
			// Specify the layout to use when the list of choices appears
			kindAdapter
					.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// Apply the adapter to the spinner
			spinnerType.setAdapter(kindAdapter);
			spinnerType.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					// TODO Auto-generated method stub
					Kind arg = (Kind) spinnerType.getSelectedItem();
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}

			});
		}

	}

}