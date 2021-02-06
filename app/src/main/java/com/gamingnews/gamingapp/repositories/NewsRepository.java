package com.gamingnews.gamingapp.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gamingnews.gamingapp.models.Channel;
import com.gamingnews.gamingapp.models.Item;
import com.gamingnews.gamingapp.models.Rss;
import com.gamingnews.gamingapp.webservices.api.NewsApiClient;

import java.util.List;

public class NewsRepository {

    private NewsApiClient newsApiClient;
    private static NewsRepository instance;

    public static NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }

    private NewsRepository() {
        newsApiClient = NewsApiClient.getInstance();
    }

    public LiveData<List<Item>> getItems() {
        return newsApiClient.getItems();
    }

    public void getNewsApi() {
        newsApiClient.getNewsApi();
    }


}
