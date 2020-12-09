package com.gamingnews.gamingapp.ui.NewsFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamingnews.gamingapp.R;
import com.gamingnews.gamingapp.databinding.FragmentNewsBinding;

public class NewsFragment extends Fragment {


    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentNewsBinding binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}