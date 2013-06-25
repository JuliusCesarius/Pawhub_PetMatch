package com.blastic.pawhub_petmatch;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blastic.utilities.Images;


public class RateMyPetActivityFragment extends Fragment {
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V = inflater.inflate(R.layout.activity_rate_my_pet, container, false);
        Drawable drawable = Images.cropImageCorner(R.drawable.petimage, R.id.imgPet, this.getResources());
        
        V.findViewById(R.id.imgPet).setBackground(drawable);
        
        return V;
        
    }
}
