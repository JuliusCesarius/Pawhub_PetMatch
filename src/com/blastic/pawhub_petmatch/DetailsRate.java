package com.blastic.pawhub_petmatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TableRow;

import com.blastic.adapters.JsonAdapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.PetBasic;
import com.blastic.clases.TopCategory;
import com.blastic.utilities.Images;

public class DetailsRate extends Activity {
	
	View detailsView;
	GenericAsyncTask<PetBasic> getPetBasicAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_rate);
		
		// llama el valor pasado por Globalrates
		Intent mIntent = getIntent();
		String value = mIntent.getStringExtra("variableName");
		Integer intValue = mIntent.getIntExtra("intval", 0);
		Log.i("valor", ""+value);
		Log.i("valor", ""+intValue);
		
		Bitmap bitmap = Images.GetBitmapClippedCircle(BitmapFactory
				.decodeResource(getResources(), R.drawable.greenbackground));
		Drawable drawable = new BitmapDrawable(getResources(),
				Images.GetBitmapClippedCircle(bitmap));
		TableRow tableRow = (TableRow) findViewById(R.id.valueRate);
		//tableRow.setBackground(drawable);
		
		String urlString = "http://wskrs.com/PetRateService/GetPetRate/"+value+"?CategoryId="+intValue;
		getPetBasicAsyncTask = new GetPetBasicAsyncTask(PetBasic.class);
		getPetBasicAsyncTask.execute(urlString);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details_rate, menu);
		return true;
	}
	
	private class GetPetBasicAsyncTask extends GenericAsyncTask<PetBasic> {

		public GetPetBasicAsyncTask(Class<PetBasic> tipo) {
			super(tipo);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		protected ArrayList<PetBasic> doInBackground(String... params) {
			int count = params.length;
			ArrayList<PetBasic> objects = new ArrayList<PetBasic>();
			if (count > 0) {
				URL url;
				try {
					url = new URL(params[0]);
					URLConnection urlc = url.openConnection();
					BufferedReader bfr = new BufferedReader(
							new InputStreamReader(urlc.getInputStream()));
					String line = bfr.readLine();
					while (line != null) {
						JSONArray jsa = new JSONArray(line);
						// ArrayAdapter<String> arrayAdapter = new
						for (int i = 0; i < jsa.length(); i++) {
							JSONObject jsonObject = (JSONObject) jsa.get(i);
							JsonAdapter<PetBasic> ja = new JsonAdapter<PetBasic>();
							PetBasic o = ja.bindJsonToClass(
									PetBasic.class, jsonObject);
							objects.add(o);
						}
					}
					return objects;
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return objects;
		}


		@Override
		protected void onPostExecute(ArrayList<PetBasic> elements) {

			detailsView = findViewById(R.layout.activity_details_rate);
			Log.i("num", ""+elements.size());

		}

	}

}