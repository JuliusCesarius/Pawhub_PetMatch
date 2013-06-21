package com.blastic.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.blastic.clases.TopCategory;
import com.blastic.pawhub_petmatch.R;

public class ListViewTopCategoryAdapter extends ArrayAdapter<TopCategory> {
	
	// Your custom values for the spinner (User)
	private TopCategory[] values;
	private TopCategory topCat;
	// Your sent context
    private Context context;
    //ImageLoader imageLoader;
	
	public ListViewTopCategoryAdapter(Activity cont, int resource, TopCategory[] values) {
		super(cont, resource, values);
		this.context = cont; 
		this.values = values;
	}
	
	public int getCount(){
	       return values.length;
	    }

	    public TopCategory getItem(int position){
	       return values[position];
	    }

	    public long getItemId(int position){
	       return position;
	    }

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
			view = inflater.inflate(R.layout.rowlayout, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((values == null) || ((position + 1) > values.length))
			return view;

		topCat = values[position];
		
		holder.lblCategory = (TextView) view.findViewById(R.id.lblCategory);
		holder.lblPetNameRates = (TextView) view.findViewById(R.id.lblPetNameRates);
		holder.lblPetVotes = (TextView) view.findViewById(R.id.lblPetVotes);
		holder.lblPetRatesPicture = (WebView) view.findViewById(R.id.lblPetRatesPicture);
		
		if (holder.lblCategory != null && null != topCat.getName() && topCat.getName().trim().length() > 0) {
			holder.lblCategory.setText(topCat.getName());
		}
		
		if (holder.lblPetNameRates != null && null != topCat.getPetName() && topCat.getPetName().trim().length() > 0) {
			holder.lblPetNameRates.setText(topCat.getPetName());
		}
		
		String rates = "" + topCat.getRates() + " Votes"; 
		
		if (holder.lblPetVotes != null && null != rates) {
			holder.lblPetVotes.setText(rates);
		}
		if (holder.lblPetRatesPicture != null && null != topCat.getPicture() && topCat.getPicture().trim().length() > 0) {
			holder.lblPetRatesPicture.loadUrl(topCat.getPicture());
		}
		/*if (holder.lblPetRatesPicture != null) {
			if (null != topCat.getPicture() && topCat.getPicture().trim().length() > 0) {

				imageLoader.init(ImageLoaderConfiguration
						.createDefault(activity));
				imageLoader.displayImage(objBean.getLink(), holder.imgView,
						options, new ImageLoadingListener() {
							@Override
							public void onLoadingComplete() {
								pbar.setVisibility(View.INVISIBLE);

							}

							@Override
							public void onLoadingFailed() {
								pbar.setVisibility(View.INVISIBLE);
							}

							@Override
							public void onLoadingStarted() {
								pbar.setVisibility(View.VISIBLE);

							}
						});

			} else {
				holder.imgView.setImageResource(R.drawable.ic_launcher);
			}
		}*/
		
		return view;
	}

	public class ViewHolder {

		public TextView lblCategory, lblPetNameRates, lblPetVotes;
		private WebView lblPetRatesPicture;

	}
     
}
