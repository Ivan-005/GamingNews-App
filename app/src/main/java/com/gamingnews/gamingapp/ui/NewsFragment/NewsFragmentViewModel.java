package com.gamingnews.gamingapp.ui.NewsFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gamingnews.gamingapp.models.Channel;
import com.gamingnews.gamingapp.repositories.NewsRepository;

import java.util.List;

public class NewsFragmentViewModel extends ViewModel {

    private NewsRepository newsRepository;

    public NewsFragmentViewModel() {
        newsRepository = NewsRepository.getInstance();
    }

    public LiveData<List<Channel>> getChannel() {
        return newsRepository.getChannel();
    }

}
