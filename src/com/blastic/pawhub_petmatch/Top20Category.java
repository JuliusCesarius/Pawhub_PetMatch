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
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.blastic.adapters.JsonAdapter;
import com.blastic.adapters.ListViewTopCategoryAdapter;
import com.blastic.adapters.TableLayoutTop20Adapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.TopCategory;

public class Top20Category extends Activity {

	ListView listTop20;
	TextView titulo;

	GenericAsyncTask<TopCategory> getTopCategoryAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top20_category);
		// llama el valor pasado por Globalrates
		Intent mIntent = getIntent();
		int intValue = mIntent.getIntExtra("intVariableName", 0);

		String urlString = "http://wskrs.com/PetRateService/GetTopCategories";
		getTopCategoryAsyncTask = new GetTopCategoryAsyncTask(TopCategory.class);
		getTopCategoryAsyncTask.execute(urlString);

		titulo = (TextView) findViewById(R.id.lblTop20);

		if (intValue == 1)
			titulo.setText("Top 20 More Softness");
		if (intValue == 2)
			titulo.setText("Top 20 More Hardness");
		if (intValue == 3)
			titulo.setText("Top 20 More Sex Appeal");
		if (intValue == 4)
			titulo.setText("Top 20 More Cuteness");
		if (intValue == 5)
			titulo.setText("Top 20 More Huggable");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.top20_category, menu);
		return true;
	}

	private class GetTopCategoryAsyncTask extends GenericAsyncTask<TopCategory> {

		public GetTopCategoryAsyncTask(Class<TopCategory> tipo) {
			super(tipo);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected ArrayList<TopCategory> doInBackground(String... params) {
			int count = params.length;
			ArrayList<TopCategory> objects = new ArrayList<TopCategory>();
			if (count > 0) {
				URL url;
				try {
					url = new URL(params[0]);
					URLConnection urlc = url.openConnection();
					BufferedReader bfr = new BufferedReader(
							new InputStreamReader(urlc.getInputStream()));
					String line;
					while ((line = bfr.readLine()) != null) {
						JSONArray jsa = new JSONArray(line);
						// ArrayAdapter<String> arrayAdapter = new
						for (int i = 0; i < jsa.length(); i++) {
							JSONObject jsonObject = (JSONObject) jsa.get(i);
							JsonAdapter<TopCategory> ja = new JsonAdapter<TopCategory>();
							TopCategory o = ja.bindJsonToClass(
									TopCategory.class, jsonObject);
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
		protected void onPostExecute(ArrayList<TopCategory> elements) {

			listTop20 = (ListView) findViewById(R.id.listTableTop20);
			TableLayoutTop20Adapter catAdapter = new TableLayoutTop20Adapter(Top20Category.this, R.layout.tablerow_layout, elements.toArray(new TopCategory[elements.size()]));
			catAdapter.setDropDownViewResource(R.layout.tablerow_layout);
			listTop20.setAdapter(catAdapter);
			Log.i("nums", "" + elements.size());

		}

	}

}
