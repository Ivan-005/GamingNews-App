package com.gamingnews.gamingapp.ui.NewsFragment;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gamingnews.gamingapp.models.Channel;
import com.gamingnews.gamingapp.models.Item;
import com.gamingnews.gamingapp.models.Rss;
import com.gamingnews.gamingapp.repositories.NewsRepository;

import java.util.List;

public class NewsFragmentViewModel extends ViewModel {

    private MutableLiveData<List<Item>> mItems;
    private NewsRepository mRepo;

    // Empty constructor
    public NewsFragmentViewModel() {

    }
    public void init() {
        if (mItems != null) {
            return;
        }
        mRepo = NewsRepository.getInstance();
        mItems = mRepo.getItems();
    }

    public LiveData<List<Item>> getItems() {
        return mItems;
    }
}
