package com.gamingnews.gamingapp.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gamingnews.gamingapp.models.Channel;
import com.gamingnews.gamingapp.models.Item;
import com.gamingnews.gamingapp.models.Rss;
import com.gamingnews.gamingapp.webservices.api.ServiceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {


    MutableLiveData<List<Item>> mItems;
    private static NewsRepository instance;

    public static NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }

    //Empty constructor
    private NewsRepository() {

    }

    public MutableLiveData<List<Item>> getItems() {
        mItems = new MutableLiveData<>();

        ServiceApi.getInstance().getGamezoneMethods().getGamezoneNews().enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                if (response.code() == 200) {
                    List<Item> items = response.body().getChannel().getItems();
                    mItems.postValue(items);
                }
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.d("Failed", "Error");
                mItems.postValue(null);
            }
        });
        return mItems;
    }
}
