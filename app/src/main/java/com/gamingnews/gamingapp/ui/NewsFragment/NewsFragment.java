package com.gamingnews.gamingapp.ui.NewsFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamingnews.gamingapp.R;
import com.gamingnews.gamingapp.databinding.FragmentNewsBinding;
import com.gamingnews.gamingapp.models.Channel;

import java.util.List;

public class NewsFragment extends Fragment {

    private NewsFragmentViewModel newsFragmentViewModel;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsFragmentViewModel = new ViewModelProvider(this).get(NewsFragmentViewModel.class);


        // Inflate the layout for this fragment
        FragmentNewsBinding binding = FragmentNewsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void observeChanges() {

        newsFragmentViewModel.getChannel().observe(this, new Observer<List<Channel>>() {
            @Override
            public void onChanged(List<Channel> channels) {
                // TO-DO
            }
        });
    }
}