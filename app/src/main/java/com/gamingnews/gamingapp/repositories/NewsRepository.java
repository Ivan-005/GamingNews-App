package com.gamingnews.gamingapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gamingnews.gamingapp.models.Channel;

import java.util.List;

public class NewsRepository {

    private MutableLiveData<List<Channel>> mChannel;

    private static NewsRepository instance;

    public static NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }

    private NewsRepository() {
        mChannel = new MutableLiveData<>();
    }

    public LiveData<List<Channel>> getChannel() {
        return mChannel;
    }
}
