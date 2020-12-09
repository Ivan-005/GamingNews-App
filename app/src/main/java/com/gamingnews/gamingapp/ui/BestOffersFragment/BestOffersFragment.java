package com.gamingnews.gamingapp.ui.BestOffersFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamingnews.gamingapp.R;
import com.gamingnews.gamingapp.databinding.FragmentBestoffersBinding;


public class BestOffersFragment extends Fragment {


    public BestOffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentBestoffersBinding binding = FragmentBestoffersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}