package com.blastic.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blastic.clases.TopCategory;
import com.blastic.pawhub_petmatch.DetailsRate;
import com.blastic.pawhub_petmatch.R;

public class TableLayoutTop20Adapter extends ArrayAdapter<TopCategory> {

	private TopCategory[] values;
	private TopCategory topCat;
	// Your sent context
	private Context context;
	LayoutInflater inflater;
	int counter;

	public TableLayoutTop20Adapter(Activity cont, int resource,
			TopCategory[] values) {
		super(cont, resource, values);
		this.context = cont;
		this.values = values;
		counter= getCount();
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

		ViewHolder holder;

		if (viewContenido == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			viewContenido = inflater.inflate(R.layout.tablerow_layout, null);
			holder = new ViewHolder();
			viewContenido.setTag(holder);
		} else {
			holder = (ViewHolder) viewContenido.getTag();
		}

		if ((values == null) || ((position + 1) > values.length))
			return viewContenido;

		topCat = values[position];
		/*
		 * int mRows = 5; int mCols = 2;
		 * 
				if (position+1 % 2 != 0) {
			holder.layoutTable.setGravity(Gravity.RIGHT);
		}
		 */
		holder.layoutHTable = (LinearLayout) viewContenido
				.findViewById(R.id.layoutHTable);
		holder.lblPetNameRates = (TextView) viewContenido
				.findViewById(R.id.lblPetNameRates);
		holder.lblPetVotes = (TextView) viewContenido
				.findViewById(R.id.lblPetVotes);
		holder.lblPetId = (TextView) viewContenido
				.findViewById(R.id.lblPetId);
		holder.lblPetRatesPicture = (WebView) viewContenido
				.findViewById(R.id.lblPetRatesPicture);

		if (counter % 2 != 0) 
			holder.layoutHTable.setGravity(Gravity.RIGHT);

		if (holder.lblPetNameRates != null && null != topCat.getPetName()
				&& topCat.getPetName().trim().length() > 0)
			holder.lblPetNameRates.setText(topCat.getPetName());

		String rates = "" + topCat.getRates() + " Votes";

		if (holder.lblPetVotes != null && null != rates)
			holder.lblPetVotes.setText(rates);

		if (holder.lblPetRatesPicture != null && null != topCat.getPicture()
				&& topCat.getPicture().trim().length() > 0) {
			String url = topCat.getPicture();
			StringBuilder builder = new StringBuilder();

			builder.append("<html><body>");
			builder.append("<img style='width: 80px; height: 80px; margin: -8px auto auto -8px;' src='"
					+ url + "' />");
			builder.append("</body></html>");

			holder.lblPetRatesPicture.loadData(builder.toString(), "text/html",
					"UTF-8");
		}
		final String id = topCat.getPetid();
		if (holder.lblPetId != null && null != id) {
			holder.lblPetId.setText(topCat.getPetName());
			
			viewContenido.setOnTouchListener(new OnTouchListener() { 

				@Override
				public boolean onTouch(View arg0, MotionEvent arg1) {
					Intent intent=new Intent(context, DetailsRate.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					intent.putExtra("variableName", id);
				    context.startActivity(intent);
					return false;
				}
				
			}); 
		}
			counter--;
		return viewContenido;

	}

	public class ViewHolder {

		public LinearLayout layoutHTable;
		public TextView lblPetNameRates, lblPetVotes, lblPetId;
		public WebView lblPetRatesPicture;

	}

}
