package com.blastic.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import com.blastic.clases.TopCategory;
import com.blastic.pawhub_petmatch.R;

public class TableLayoutTop20Adapter extends ArrayAdapter<TopCategory> {
	
	private TopCategory[] values;
	private TopCategory topCat;
	// Your sent context
    private Context context;
    LayoutInflater inflater;
    
    public TableLayoutTop20Adapter(Activity cont, int resource, TopCategory[] values){
    	super(cont, resource, values);
		this.context = cont;
		this.values = values;
    }
    
    public int getCount() {
		return values.length;
	}

	public TopCategory getItem(int position) {
		return values[position];
	}

	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View viewContenido = convertView;
		View view2 = parent.getRootView();
		TableLayout table = (TableLayout)view2.findViewById(R.id.tableTop20);
		
		
		ViewHolder holder;
		
		if (viewContenido == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewContenido = inflater.inflate(R.layout.tablerow_layout, null);
			holder = new ViewHolder();
			viewContenido.setTag(holder);
		} else {
			holder = (ViewHolder) viewContenido.getTag();
		}
		
		if ((values == null) || ((position + 1) > values.length))
			return viewContenido;
		
		topCat = values[position];
		int mRows = 5;
		int mCols = 2;
		
		holder.lblPetNameRates = (TextView) viewContenido.findViewById(R.id.lblPetNameRates);
		holder.lblPetVotes = (TextView) viewContenido.findViewById(R.id.lblPetVotes);
		holder.lblPetRatesPicture = (WebView) viewContenido.findViewById(R.id.lblPetRatesPicture);
		
		if (holder.lblPetNameRates != null && null != topCat.getPetName() && topCat.getPetName().trim().length() > 0) 
			holder.lblPetNameRates.setText(topCat.getPetName());
		
		String rates = "" + topCat.getRates() + " Votes"; 
		
		if (holder.lblPetVotes != null && null != rates) 
			holder.lblPetVotes.setText(rates);
		
		if (holder.lblPetRatesPicture != null && null != topCat.getPicture() && topCat.getPicture().trim().length() > 0) {
			String url = topCat.getPicture();

			StringBuilder builder = new StringBuilder();

			builder.append("<html><body>");
			builder.append("<img style='width: 70px; height: 70px; margin: -8px auto auto -8px;' src='"
					+ url + "' />");
			builder.append("</body></html>");

			holder.lblPetRatesPicture.loadData(builder.toString(), "text/html",
					"UTF-8");
		}
		
		
		 for (int i = 0; i < mRows; i++) { 

		    	// Create a TableRow and give it an ID
	            TableRow tr = new TableRow(context);
	            tr.setId(100+i);
	            tr.setLayoutParams(new LayoutParams());
	            
	            for (int j = 0; j < mCols; j++) {

	            	ImageView picture = new ImageView(context);
		            picture.setImageResource(R.drawable.top20);
		            
		            TextView textName = new TextView(context);
		            holder.lblPetNameRates.setText("ROcko");
		            tr.addView(picture);  
		            
	            }

		        table.addView(tr);
		    }
		
		
		
		return viewContenido;
		
	}
	
	public class ViewHolder {

		public TextView lblPetNameRates, lblPetVotes;
		public WebView lblPetRatesPicture;

	}
    
	

}
