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
	
	public void onAttach(Activity activity) {
		super.onAttach(activity);
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
			if (GLOBAL_RATES.equals(tabId)) {
				updateTab(tabId, R.id.tabViewGlobalRates);
				mCurrentTab = 2;
	            return;
	        }
	    }

}
