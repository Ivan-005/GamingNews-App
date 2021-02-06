package com.gamingnews.gamingapp.webservices.api;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gamingnews.gamingapp.AppExecutors;
import com.gamingnews.gamingapp.models.Channel;
import com.gamingnews.gamingapp.models.Item;
import com.gamingnews.gamingapp.models.Rss;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class NewsApiClient {

    // Live Data
    private MutableLiveData<List<Item>> mItems;
    private static NewsApiClient instance;

    //Instantiating Runnable object
    private RetrieveNewsRunnable retrieveNewsRunnable;


    private NewsApiClient() {
        mItems = new MutableLiveData<>();
    }


    public static NewsApiClient getInstance() {
        if (instance == null) {
            instance = new NewsApiClient();
        }
        return instance;
    }

    public LiveData<List<Item>> getItems() {
        return mItems;
    }

    public void getNewsApi() {
        if (retrieveNewsRunnable != null) {
            retrieveNewsRunnable = null;
        }
        retrieveNewsRunnable = new RetrieveNewsRunnable();

        final Future myHandler = AppExecutors.getInstance().getNetworkIO().submit(retrieveNewsRunnable);

        AppExecutors.getInstance().getNetworkIO().schedule(new Runnable() {
            @Override
            public void run() {
                myHandler.cancel(true);
            }
        }, 5000, TimeUnit.MILLISECONDS);
    }


    // Nested Class
    private class RetrieveNewsRunnable implements Runnable {

        ServiceApi serviceApi;
        boolean cancelRequest;

        public RetrieveNewsRunnable(){
            cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getNews().execute();
                if (cancelRequest) {
                    return;
                }
                if (response.code() == 200) {
                    List<Item> dataList = new ArrayList<>(((Rss) response.body()).getChannel().getItems());
                    mItems.postValue(dataList);

                } else {
                    String errorMsg = response.errorBody().string();
                    Log.d("ERROR MESSAGE", errorMsg);
                    mItems.postValue(null);
                }

            }
            catch (IOException e) {
                e.printStackTrace();
                mItems.postValue(null);
            }
        }


        private Call<Rss> getNews() {
            return serviceApi.getIgnMethods().getIgnNews();
        }

        private void cancelRequest() {
            Log.d("DEBUG", "Cancelling search request");
            cancelRequest = true;
        }






    }

}
