package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;


public class GlobalRatesActivity extends Activity {
		
		ListView listMyRates, listGlobal;
		
		String[] mascotasGlobalCategory = {"Top 20 Cuteness", "Top 20 SexAppeal", "Top 20 Hugabble", "Top 20 Funny", "Top 20 Fierce"};
		
		String[] mascotasMyRatesNames = {"Rocko", "Pucky", "Mr Rodo", "Hanibbal", "Piwy", "Mojito", "Coco", "Oreo"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_global_rates);

		//se obtienen resources para las tabs
				Resources res = getResources();
				/** Obteniendo una referencia al control principal TabHost y prepar�ndolo para su 
				 * configuraci�n llamando a su m�todo setup
				 */
				TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
				tabs.setup(); 
				/**Creamos un objeto de tipo TabSpec para cada una de las pesta�as que queramos 
				 * a�adir mediante el m�todo newTabSpec, le pasamos como par�metro una etiqueta 
				 * identificativa "tabRatePet" para tab1 
				 * 
				 */
				TabHost.TabSpec spec=tabs.newTabSpec("tabRatePet");
				
				// Asignamos el layout de contenido correspondiente a la pesta�a llamando al m�todo setContent
				spec.setContent(R.id.tabRatePet);
				
				/**Indicamos el texto y el icono que queremos mostrar en la pesta�a mediante el m�todo setIndicator
				 * el comportamiento difiere entre las distintas versiones de Android. En Android 4, el comportamiento 
				 * por defecto del control TabHost es mostrar s�lo el texto, o solo el icono, pero no ambos.
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
				
				listMyRates = (ListView)findViewById(R.id.listMyRates);
				
				//usamos nuestro layout, asignamos para lblPetNameRates
				ArrayAdapter<String> adapterMyRates = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.lblPetNameRates, mascotasMyRatesNames);
				listMyRates.setAdapter(adapterMyRates);
				
				//Asignamos valores para el listview de tab3 global rates
				
				listGlobal = (ListView)findViewById(R.id.listGlobalRates);
				ArrayAdapter<String> adapterGlobalC =  new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.lblCategory, mascotasGlobalCategory);
				listGlobal.setAdapter(adapterGlobalC);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.global_rates, menu);
		return true;
	}



}
