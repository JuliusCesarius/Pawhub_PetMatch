package com.blastic.clases;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GenericArrayAdapter<T> extends BaseAdapter {
	private Context cont;
	private int resource;
	private ArrayList<T> elementos;
	public GenericArrayAdapter(Context context, int layOut, ArrayList<T> elements){
		
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHold viewh = new ViewHold();
		View view = convertView;
		if(view==null){
			view = LayoutInflater.from(cont).inflate(resource, parent);
			viewh.textView = (TextView) view.findViewById(android.R.id.text1);
		}
		//TODO: Determinar si este adapter se puede hacer genérico, si nó... usar un adapter para cada view diferente
		//viewh.textView.setText(elementos[position].get)
		return null;
	}
	
	class ViewHold{
		public TextView textView;
	}
	
}
