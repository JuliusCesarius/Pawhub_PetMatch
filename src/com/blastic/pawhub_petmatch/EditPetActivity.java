package com.blastic.pawhub_petmatch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

import com.blastic.adapters.JsonAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Shader.TileMode;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class EditPetActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_pet);
		  
		Spinner spinnerType = (Spinner) findViewById(R.id.spinEditType);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterType = ArrayAdapter.createFromResource(this, R.array.editType_array, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerType.setAdapter(adapterType); 
		
		Spinner spinnerBreed = (Spinner) findViewById(R.id.spinEditBreed);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapterBreed = ArrayAdapter.createFromResource(this, R.array.editBreed_array, android.R.layout.simple_spinner_item);
		//Specify the layout to use when the list of choices appears
		adapterBreed.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerBreed.setAdapter(adapterBreed); 

		String str="http://wskrs.com/profile/getkinds";
		String title;
		String des;
	    try{
	        URL url=new URL(str);
	        URLConnection urlc=url.openConnection();
	        BufferedReader bfr=new BufferedReader(new InputStreamReader(urlc.getInputStream()));
	        String line;
	        while((line=bfr.readLine())!=null)
	        {
		        JSONArray jsa=new JSONArray(line);
		        for(int i=0;i<jsa.length();i++)
	           {
		           JSONObject jsonObject =(JSONObject)jsa.get(i);
		           Kind kind = JsonAdapter.bindJsonToClass(Kind.class, jsonObject);
		           if(kind!=null){
		        	   return;
		           }
	           }
	        }
	    }
	    catch(Exception e){
	    	String a = e.getMessage();
	    }
		
	} 
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_pet, menu);
		return true;
	}

}
