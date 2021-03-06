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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.blastic.adapters.JsonAdapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.TopCategory;

public class Top20Category extends Activity {

	ListView listTop20;
	TextView titulo;
	int intValue;

	GenericAsyncTask<TopCategory> getTopCategoryAsyncTask;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_top20_category);
		// llama el valor pasado por Globalrates
		Intent mIntent = getIntent();
		intValue = mIntent.getIntExtra("intVariableName", 0);

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
			
			TableLayout table =  (TableLayout) findViewById(R.id.top20table);
			
			int mRows = 3;
			int mCols = 2;
			int count = 0;
			
		    for (int i = 0; i < mRows; i++) {

		    	// Create a TableRow and give it an ID
	            TableRow tr = new TableRow(Top20Category.this);
	            tr.setId(100+i);
	            tr.setLayoutParams(new LayoutParams());
	            for (int j = 0; j < mCols; j++) {
		            
		            if(count < elements.size()){
		            //Log.i(""+count,""+elements.get(count).getPetName());
		            
		            TopCategory element = elements.get(count);
		            LayoutInflater inflater = (LayoutInflater)  Top20Category.this.getSystemService(LAYOUT_INFLATER_SERVICE);
		            View childLayout = inflater.inflate(R.layout.tablerow_layout, (ViewGroup) findViewById(R.layout.tablerow_layout));
		            
		    		TextView lblPetNameRates = (TextView) childLayout.findViewById(R.id.lblPetNameRates);
		    		TextView lblPetVotes = (TextView) childLayout.findViewById(R.id.lblPetVotes);
		    		TextView lblPetId = (TextView) childLayout.findViewById(R.id.lblPetId);
		    		WebView lblPetRatesPicture = (WebView) childLayout.findViewById(R.id.lblPetRatesPicture);
		    		
		    		if (lblPetNameRates != null && null != element.getPetName()
		    				&& element.getPetName().trim().length() > 0)
		    			lblPetNameRates.setText(element.getPetName());

		    		String rates = "" + element.getRates() + " Votes";

		    		if (lblPetVotes != null && null != rates)
		    			lblPetVotes.setText(rates);

		    		if (lblPetRatesPicture != null && null != element.getPicture()
		    				&& element.getPicture().trim().length() > 0) {
		    			String url = element.getPicture();
		    			StringBuilder builder = new StringBuilder();

		    			builder.append("<html><body>");
		    			builder.append("<img style='width: 80px; height: 80px; margin: -8px auto auto -8px;' src='"
		    					+ url + "' />");
		    			builder.append("</body></html>");

		    			lblPetRatesPicture.loadData(builder.toString(), "text/html",
		    					"UTF-8");
		    		}
		    		final String id = element.getPetid();
		    		if (lblPetId != null && null != id) {
		    			lblPetId.setText(element.getPetid());
		    			
		    			lblPetRatesPicture.setOnTouchListener(new OnTouchListener() { 

		    				@Override
		    				public boolean onTouch(View arg0, MotionEvent arg1) {
		    					
		    					Intent intent=new Intent(Top20Category.this, DetailsRate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		    					intent.putExtra("variableName", id);
		    					intent.putExtra("intval", intValue);
		    					Top20Category.this.startActivity(intent);
		    					
		    					
		    					return true;
		    				}
		    				
		    			});
		    			 
		    		}
		            
		            tr.addView(childLayout);
		            
		            	count++;
		            }
		            
	            }


		        table.addView(tr);
		    }

		}

	}

}
