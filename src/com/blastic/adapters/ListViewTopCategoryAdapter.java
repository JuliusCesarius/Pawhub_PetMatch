package com.blastic.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.blastic.clases.TopCategory;
import com.blastic.pawhub_petmatch.R;
import com.blastic.pawhub_petmatch.Top20Category;

public class ListViewTopCategoryAdapter extends ArrayAdapter<TopCategory> {

	// Your custom values for the spinner (User)
	private TopCategory[] values;
	private TopCategory topCat;
	// Your sent context
	private Context context;

	// ImageLoader imageLoader;

	public ListViewTopCategoryAdapter(Activity cont, int resource,
			TopCategory[] values) {
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

		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			view = inflater.inflate(R.layout.rowlayout, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((values == null) || ((position + 1) > values.length))
			return view;

		topCat = values[position];
		final int idCategoria = (Integer) topCat.getRateCategoryId();

		holder.lblCategory = (TextView) view.findViewById(R.id.lblCategory);
		holder.lblPetNameRates = (TextView) view
				.findViewById(R.id.lblPetNameRates);
		holder.lblPetVotes = (TextView) view.findViewById(R.id.lblPetVotes);
		holder.lblPetRatesPicture = (WebView) view
				.findViewById(R.id.lblPetRatesPicture);

		if (holder.lblPetNameRates != null && null != topCat.getName()
				&& topCat.getName().trim().length() > 0) {
			holder.lblPetNameRates.setTextSize(22);
			holder.lblPetNameRates.setPadding(0, -15, 0, 0);
			holder.lblCategory.setText("");
			holder.lblPetVotes.setText("");
			holder.lblPetNameRates.setText("Top 20 More " + topCat.getName());
		}

		if (holder.lblPetRatesPicture != null && null != topCat.getPicture()
				&& topCat.getPicture().trim().length() > 0) {

			String url = topCat.getPicture();

			StringBuilder builder = new StringBuilder();

			builder.append("<html><body>");
			builder.append("<img style='width: 50px; height: 50px; margin: -8px auto auto -8px;' src='"
					+ url + "' />");
			builder.append("</body></html>");

			holder.lblPetRatesPicture.loadData(builder.toString(), "text/html",
					"UTF-8");
			
			if(idCategoria != 0){
				view.setOnTouchListener(new OnTouchListener() {

					@Override
					public boolean onTouch(View arg0, MotionEvent arg1) {
						Intent intent=new Intent(context,Top20Category.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
						intent.putExtra("intVariableName", idCategoria);
					    context.startActivity(intent);
						return false;
					}
					
				});
			}

		}
		/*
		 * if (holder.lblPetRatesPicture != null) { if (null !=
		 * topCat.getPicture() && topCat.getPicture().trim().length() > 0) {
		 * 
		 * imageLoader.init(ImageLoaderConfiguration .createDefault(activity));
		 * imageLoader.displayImage(objBean.getLink(), holder.imgView, options,
		 * new ImageLoadingListener() {
		 * 
		 * @Override public void onLoadingComplete() {
		 * pbar.setVisibility(View.INVISIBLE);
		 * 
		 * }
		 * 
		 * @Override public void onLoadingFailed() {
		 * pbar.setVisibility(View.INVISIBLE); }
		 * 
		 * @Override public void onLoadingStarted() {
		 * pbar.setVisibility(View.VISIBLE);
		 * 
		 * } });
		 * 
		 * } else { holder.imgView.setImageResource(R.drawable.ic_launcher); } }
		 */

		return view;
	}

	public class ViewHolder {

		public TextView lblCategory, lblPetNameRates, lblPetVotes;
		public WebView lblPetRatesPicture;

	}

}
