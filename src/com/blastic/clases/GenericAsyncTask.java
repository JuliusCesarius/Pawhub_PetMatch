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

public class GenericAsyncTask<T> extends AsyncTask<String, Void, ArrayList<T>> {
	private Class<T> type;
	private Context context;
	int layOut;
	AdapterView<ArrayAdapter<String>> view;
	
	public GenericAsyncTask(Class<T> tipo){
		type = tipo;
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
}
