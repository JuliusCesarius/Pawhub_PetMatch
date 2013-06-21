package com.blastic.pawhub_petmatch;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class Tabs extends Fragment implements OnTabChangeListener {
	private static final String TAG = "FragmentTabs";
	public static final String RATE_A_PET = "Rate a Pet";
	public static final String MY_RATES = "My Rates";
	public static final String GLOBAL_RATES = "Global Rates";
	
	private View mRoot;
	private TabHost mTabHost;
	private int mCurrentTab;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRoot = inflater.inflate(R.layout.tabs_layout, null);
		mTabHost = (TabHost) mRoot.findViewById(android.R.id.tabhost);
		setupTabs();
		return mRoot;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setRetainInstance(true);

		mTabHost.setOnTabChangedListener(this);
		mTabHost.setCurrentTab(mCurrentTab);
		// manually start loading stuff in the first tab
		updateTab(RATE_A_PET, R.id.tabRateAPet);
	}

	
	
	private void setupTabs() {
		mTabHost.setup(); // important!
		mTabHost.addTab(newTab(RATE_A_PET, R.string.tabRateAPet, R.id.tabRateAPet));
		mTabHost.addTab(newTab(MY_RATES, R.string.tabViewMyRates, R.id.tabViewMyRates));
//		mTabHost.addTab(newTab(GLOBAL_RATES, R.string.tabGLobalRates, R.id.tabViewGlobalRates));
	}

	private TabSpec newTab(String tag, int labelId, int tabContentId) {
		Log.d(TAG, "buildTab(): tag=" + tag);

		View indicator = LayoutInflater.from(getActivity()).inflate(
				R.layout.tab,
				(ViewGroup) mRoot.findViewById(android.R.id.tabs), false);
		((TextView) indicator.findViewById(R.id.text)).setText(labelId);

		TabSpec tabSpec = mTabHost.newTabSpec(tag);
		tabSpec.setIndicator(indicator);
		tabSpec.setContent(tabContentId);
		return tabSpec;
	}

	
	@Override
	public void onTabChanged(String tabId) {
		Log.d(TAG, "onTabChanged(): tabId=" + tabId);
		if (RATE_A_PET.equals(tabId)) {
			updateTab(tabId, R.id.tabRateAPet);
			mCurrentTab = 0;
			return;
		}
		if (MY_RATES.equals(tabId)) {
			updateTab(tabId, R.id.tabViewMyRates);
			mCurrentTab = 1;
			return;
		}
//		if (GLOBAL_RATES.equals(tabId)) {
//			updateTab(tabId, R.id.tabViewGlobalRates);
//			mCurrentTab = 2;
//			return;
//		}
	}	
	private void updateTab(String tabId, int placeholder) {
		FragmentManager fm = getFragmentManager();
		MyListFragment myListFragment = new MyListFragment();
		Bundle args = new Bundle();
		args.putString("tabId", tabId);
		myListFragment.setArguments(args);
		if (fm.findFragmentByTag(tabId) == null) {
			fm.beginTransaction()
					.replace(placeholder, myListFragment, tabId)
					.commit();
		}
	}

}
