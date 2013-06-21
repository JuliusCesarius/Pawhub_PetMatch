package com.blastic.pawhub_petmatch;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class RateMyPetActivity extends Fragment {
	
	public RateMyPetActivity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     // Inflate the layout for this fragment
      View V = inflater.inflate(R.layout.activity_rate_my_pet, container, false);
      return V;
    }

}
