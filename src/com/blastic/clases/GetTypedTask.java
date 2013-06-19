package com.blastic.clases;

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

import com.blastic.adapters.JsonAdapter;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class GetTypedTask<T> extends AsyncTask<String, Void, ArrayList<T>> {
	private Class<T> type;
	private Context context;
	int layOut;
	AdapterView<ArrayAdapter<String>> view;
	
	public GetTypedTask(Class<T> tipo, Context contxt, int lay, Object comp){
		type = tipo;
		context = contxt;
		layOut = lay;
		view = (AdapterView<ArrayAdapter<String>>)comp;
	}
	
	@Override
	protected ArrayList<T> doInBackground(String... params) {
		int count = params.length;
        ArrayList<T> objects =  new ArrayList<T>();	
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
			           JsonAdapter<T> ja = new JsonAdapter<T>();
			           T o = ja.bindJsonToClass(type, jsonObject);
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
	protected void onProgressUpdate(Integer... progress) {
        Log.i("", "msg");
    }
	@Override
	protected void onPostExecute(ArrayList<T> elements){
		super.onPostExecute(elements);
//		for (T t : elements) {
//			t.
//		}
		ArrayAdapter<String> kindAdapter = new ArrayAdapter<String>(context,layOut, (String[]) elements.toArray());
		//Specify the layout to use when the list of choices appears
		kindAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		view.setAdapter(kindAdapter);
	}
}
