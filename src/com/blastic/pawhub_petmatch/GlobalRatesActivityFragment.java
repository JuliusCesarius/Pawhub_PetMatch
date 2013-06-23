package com.blastic.pawhub_petmatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.blastic.adapters.JsonAdapter;
import com.blastic.adapters.ListViewTopCategoryAdapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.TopCategory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class GlobalRatesActivityFragment extends Fragment{
	
	ListView listGlobal;
	
	GenericAsyncTask<TopCategory> getTopCategoryAsyncTask;
	List<TopCategory> arrayOfList;
	View V;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
		
		V = inflater.inflate(R.layout.activity_global_rates, container, false);
		
		String urlString = "http://wskrs.com/PetRateService/GetTopCategories";
		getTopCategoryAsyncTask = new GetTopCategoryAsyncTask(TopCategory.class);
		getTopCategoryAsyncTask.execute(urlString);
		
		return V;
    	
    }
	
	private class GetTopCategoryAsyncTask extends GenericAsyncTask<TopCategory> {

		public GetTopCategoryAsyncTask(Class<TopCategory> tipo) {
			super(tipo);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		protected ArrayList<TopCategory> doInBackground(String... params) {
			int count = params.length;
	        ArrayList<TopCategory> objects =  new ArrayList<TopCategory>();	
			if(count>0){
				URL url;
				try {
					url = new URL(params[0]);
			        URLConnection urlc=url.openConnection();
			        BufferedReader bfr=new BufferedReader(new InputStreamReader(urlc.getInputStream()));
			        String line;
			        while((line=bfr.readLine())!=null)
			        {
				        JSONArray jsa=new JSONArray(line);
			        	//ArrayAdapter<String> arrayAdapter = new
				        for(int i=0;i<jsa.length();i++)
			           {		        	
				           JSONObject jsonObject =(JSONObject)jsa.get(i);
				           JsonAdapter<TopCategory> ja = new JsonAdapter<TopCategory>();
				           TopCategory o = ja.bindJsonToClass(TopCategory.class, jsonObject);
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
			
		listGlobal = (ListView)V.findViewById(R.id.listGlobalRates);
		ListViewTopCategoryAdapter catAdapter = new ListViewTopCategoryAdapter(GlobalRatesActivityFragment.this.getActivity(), R.layout.rowlayout, elements.toArray(new TopCategory[elements.size()]));
		catAdapter.setDropDownViewResource(R.layout.rowlayout);
		listGlobal.setAdapter(catAdapter);
		
		} 
		
	} 

}
