package com.blastic.pawhub_petmatch;

import java.util.ArrayList;
<<<<<<< HEAD

import com.blastic.clases.GetTypedTask;
=======
import java.util.Arrays;

import com.blastic.adapters.SpinKindAdapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.Kind;
>>>>>>> 72f080927dcfdcc58bcfd17cb58e4b455bb87b0a

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditPetActivity extends Activity {

	GenericAsyncTask<Kind> getKindsAsyncTask;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_pet);
<<<<<<< HEAD
		

		Spinner spinnerType = (Spinner) findViewById(R.id.spinEditType);
		
		String urlString="http://wskrs.com/profile/getkinds";
		GetTypedTask<Kind> kindTask = new GetTypedTask<Kind>(Kind.class,EditPetActivity.this, android.R.layout.simple_spinner_item, spinnerType);
		AsyncTask<String, Void, ArrayList<Kind>> kinds = kindTask.execute(urlString);
				
		ArrayAdapter<String> kindAdapter = new ArrayAdapter<String>(EditPetActivity.this, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		kindAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerType.setAdapter(kindAdapter); 
=======

		String urlString="http://wskrs.com/profile/getkinds";
		getKindsAsyncTask = new GetKindTask(Kind.class);
		getKindsAsyncTask.execute(urlString);
>>>>>>> 72f080927dcfdcc58bcfd17cb58e4b455bb87b0a
		
		Spinner spinnerBreed = (Spinner) findViewById(R.id.spinEditBreed);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterBreed = ArrayAdapter.createFromResource(this, R.array.editBreed_array, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		adapterBreed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerBreed.setAdapter(adapterBreed); 
<<<<<<< HEAD


		
		
        //lista.SetAdapter
        //HijaAsyncTask<String, Void, Kind> at = new AsyncTask<String, Void, Kind>();
        //Crear
        //execute("URL", etc)
        //onBackground()
        //onPostExecuted
		
	} 
	
	
=======
	
	}	
>>>>>>> 72f080927dcfdcc58bcfd17cb58e4b455bb87b0a

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_pet, menu);
		return true;
	}

<<<<<<< HEAD
	
=======
>>>>>>> 72f080927dcfdcc58bcfd17cb58e4b455bb87b0a
	public void onBtnFinish_Click(View v) {
		Intent i = new Intent(this, GlobalRatesActivity.class);
		startActivity(i);
	}
	public void onspinEditType_Click(View view){
		View spinner = view;
	}

    private class GetKindTask extends GenericAsyncTask<Kind> { 

    	protected GetKindTask(Class<Kind> tipo) {
			super(tipo);
		}
    	@Override
        protected void onPostExecute(ArrayList<Kind> elements){
    		final Spinner spinnerType = (Spinner) findViewById(R.id.spinEditType);
    		SpinKindAdapter kindAdapter = new SpinKindAdapter(EditPetActivity.this, android.R.layout.simple_spinner_item, elements.toArray(new Kind[elements.size()]));
    		//Specify the layout to use when the list of choices appears
    		kindAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    		// Apply the adapter to the spinner
    		spinnerType.setAdapter(kindAdapter);
    		spinnerType.setOnItemSelectedListener( new OnItemSelectedListener() {

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
