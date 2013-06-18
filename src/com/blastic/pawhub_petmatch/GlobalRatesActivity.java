package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class GlobalRatesActivity extends Activity {
	
	ListView list;
	String[] mascotas = {"Rocko", "Pucky", "Mr Rodo", "Hanibbal", "Piwy", "Mojito", "Coco", "Oreo"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_global_rates);

		
		//aignamos valores para el listview de tab3 global rates
		
		list = (ListView)findViewById(R.id.listGlobalRates);
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mascotas);
		list.setAdapter(adaptador);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.global_rates, menu);
		return true;
	}

}
