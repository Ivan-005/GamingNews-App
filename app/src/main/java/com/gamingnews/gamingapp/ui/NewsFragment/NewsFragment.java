package com.gamingnews.gamingapp.ui.NewsFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gamingnews.gamingapp.R;
import com.gamingnews.gamingapp.databinding.FragmentNewsBinding;
import com.gamingnews.gamingapp.models.Channel;
import com.gamingnews.gamingapp.models.Item;
import com.gamingnews.gamingapp.models.Rss;
import com.gamingnews.gamingapp.repositories.NewsRepository;

import java.util.List;

public class NewsFragment extends Fragment {

    FragmentNewsBinding binding;
    public NewsFragmentViewModel newsFragmentViewModel;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsFragmentViewModel = new ViewModelProvider(this).get(NewsFragmentViewModel.class);
        // Inflating the layout for this fragment
        binding = FragmentNewsBinding.inflate(inflater, container, false);
        observeChanges();
        getNewsApi();
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void getNewsApi() {
        newsFragmentViewModel.getNewsApi();
    }

    public void observeChanges() {

        newsFragmentViewModel.getItems().observe(getViewLifecycleOwner(), new Observer<List<Item>>() {

            @Override
            public void onChanged(List<Item> items) {
                Log.d("VLEZE", "FUNCKCIJA");
                if (items != null) {

                    for (Item item: items) {
                        Log.d("s", "--------------------------------------------" + item + "--------------------------------------------");
                        Log.d("RABOTI", "--------------------------------" + item.getTitle() + "---------------------------------");
                        String zzz = item.getTitle();
                        
                    }
                }
            }
        });
    }
}