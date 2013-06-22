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

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TabHost;

import com.blastic.adapters.JsonAdapter;
import com.blastic.adapters.ListViewMyRatesAdapter;
import com.blastic.adapters.ListViewTopCategoryAdapter;
import com.blastic.clases.GenericAsyncTask;
import com.blastic.clases.TopCategory;


public class GlobalRatesActivity extends Activity {
		
		ListView listMyRates, listGlobal;
		
		GenericAsyncTask<TopCategory> getTopCategoryAsyncTask;
		List<TopCategory> arrayOfList;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_global_rates);
		
		String urlString = "http://wskrs.com/PetRateService/GetTopCategories";
		getTopCategoryAsyncTask = new GetTopCategoryAsyncTask(TopCategory.class);
		getTopCategoryAsyncTask.execute(urlString);

		//se obtienen resources para las tabs
				Resources res = getResources();
				/** Obteniendo una referencia al control principal TabHost y preparándolo para su 
				 * configuración llamando a su método setup
				 */
				TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
				tabs.setup(); 
				/**Creamos un objeto de tipo TabSpec para cada una de las pestañas que queramos 
				 * añadir mediante el método newTabSpec, le pasamos como parámetro una etiqueta 
				 * identificativa "tabRatePet" para tab1 
				 * 
				 */
				TabHost.TabSpec spec=tabs.newTabSpec("tabRatePet");
				
				// Asignamos el layout de contenido correspondiente a la pestaña llamando al método setContent
				spec.setContent(R.id.tabRatePet);
				
				/**Indicamos el texto y el icono que queremos mostrar en la pestaña mediante el método setIndicator
				 * el comportamiento difiere entre las distintas versiones de Android. En Android 4, el comportamiento 
				 * por defecto del control TabHost es mostrar sólo el texto, o solo el icono, pero no ambos.
				 */
				spec.setIndicator("RATE A PET",
				res.getDrawable(android.R.drawable.ic_btn_speak_now)); //CAMBIAR ICONO
				tabs.addTab(spec);
				 
				//TAB2
				spec=tabs.newTabSpec("tabMyRates");
				spec.setContent(R.id.tabMyRates);
				spec.setIndicator("MY RATES",
				    res.getDrawable(android.R.drawable.ic_btn_speak_now)); //CAMBIAR ICONO
				tabs.addTab(spec);
				
				//TAB3
				spec=tabs.newTabSpec("tabGlobalRates");
				spec.setContent(R.id.tabGlobalRates);
				spec.setIndicator("GLOBAL RATES",
				    res.getDrawable(android.R.drawable.ic_btn_speak_now)); //CAMBIAR ICONO
				tabs.addTab(spec);
				 
				tabs.setCurrentTab(0);

				//Asignamos valores para el listview de tab2 my rates
				
				
				
				//usamos nuestro layout, asignamos para lblPetNameRates
				/*ArrayAdapter<String> adapterMyRates = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.lblPetNameRates, mascotasMyRatesNames);
				listMyRates.setAdapter(adapterMyRates);*/
				
				//Asignamos valores para el listview de tab3 global rates
				
				
				/*
				ArrayAdapter<String> adapterGlobalC =  new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.lblCategory, mascotasGlobalCategory);
				listGlobal.setAdapter(adapterGlobalC);*/
							
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.global_rates, menu);
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
			
		listGlobal = (ListView)findViewById(R.id.listGlobalRates);
		ListViewTopCategoryAdapter catAdapter = new ListViewTopCategoryAdapter(GlobalRatesActivity.this, R.layout.rowlayout, elements.toArray(new TopCategory[elements.size()]));
		catAdapter.setDropDownViewResource(R.layout.rowlayout);
		listGlobal.setAdapter(catAdapter);

		listMyRates = (ListView)findViewById(R.id.listMyRates);
		ListViewMyRatesAdapter ratesAdapter = new ListViewMyRatesAdapter(GlobalRatesActivity.this, R.layout.rowlayout, elements.toArray(new TopCategory[elements.size()]));
		ratesAdapter.setDropDownViewResource(R.layout.rowlayout);
		listMyRates.setAdapter(ratesAdapter);
		
		}
		
	}


	}

