package com.blastic.pawhub_petmatch;

import java.util.ArrayList;

import com.blastic.clases.GetTypedTask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditPetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_pet);
		

		Spinner spinnerType = (Spinner) findViewById(R.id.spinEditType);
		
		String urlString="http://wskrs.com/profile/getkinds";
		GetTypedTask<Kind> kindTask = new GetTypedTask<Kind>(Kind.class,EditPetActivity.this, android.R.layout.simple_spinner_item, spinnerType);
		AsyncTask<String, Void, ArrayList<Kind>> kinds = kindTask.execute(urlString);
				
		ArrayAdapter<String> kindAdapter = new ArrayAdapter<String>(EditPetActivity.this, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		kindAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerType.setAdapter(kindAdapter); 
		
		Spinner spinnerBreed = (Spinner) findViewById(R.id.spinEditBreed);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterBreed = ArrayAdapter.createFromResource(this, R.array.editBreed_array, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		adapterBreed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerBreed.setAdapter(adapterBreed); 


		
		
        //lista.SetAdapter
        //HijaAsyncTask<String, Void, Kind> at = new AsyncTask<String, Void, Kind>();
        //Crear
        //execute("URL", etc)
        //onBackground()
        //onPostExecuted
		
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

}
