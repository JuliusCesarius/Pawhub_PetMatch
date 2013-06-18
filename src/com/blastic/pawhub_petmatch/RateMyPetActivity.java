package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;


public class RateMyPetActivity extends Activity {
	
	ListView listGlobal;
	ListView listMyRates;
	View row;
	//valores de las listas
	String[] mascotasGlobalNames = {"Rocko", "Pucky", "Mr Rodo", "Hanibbal", "Piwy", "Mojito", "Coco", "Oreo"};
	String[] mascotasGlobalCategory = {"Rocko", "Pucky", "Mr Rodo", "Hanibbal", "Piwy", "Mojito", "Coco", "Oreo"};
	
	String[] mascotasMyRatesNames = {"Rocko", "Pucky", "Mr Rodo", "Hanibbal", "Piwy", "Mojito", "Coco", "Oreo"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rate_my_pet);
		
		/**se obtienen resources para las tabs
		Resources res = getResources();
		 Obteniendo una referencia al control principal TabHost y preparándolo para su 
		 * configuración llamando a su método setup
		 
		TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
		tabs.setup(); 
		/**Creamos un objeto de tipo TabSpec para cada una de las pestañas que queramos 
		 * añadir mediante el método newTabSpec, le pasamos como parámetro una etiqueta 
		 * identificativa "tabRatePet" para tab1 
		 * 
		 
		TabHost.TabSpec spec=tabs.newTabSpec("tabRatePet");
		

		
		/**Indicamos el texto y el icono que queremos mostrar en la pestaña mediante el método setIndicator
		 * el comportamiento difiere entre las distintas versiones de Android. En Android 4, el comportamiento 
		 * por defecto del control TabHost es mostrar sólo el texto, o solo el icono, pero no ambos.
		 
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
		
		listMyRates = (ListView)findViewById(R.id.listGlobalRates);
		//ArrayAdapter<String> adaptadorMyRates = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mascotasMyRates);
		//usamos nuestro layout
		ArrayAdapter<String> adapterMyRates = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.lblCategory, mascotasMyRatesNames);
		listMyRates.setAdapter(adapterMyRates);

		
		//Asignamos valores para el listview de tab3 global rates
		
		listGlobal = (ListView)findViewById(R.id.listMyRates);
		ArrayAdapter<String> adaptadorGlobal =  new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.lblCategory, mascotasGlobalNames);
		listGlobal.setAdapter(adaptadorGlobal);
		**/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rate_my_pet, menu);
		return true;
	}

}
