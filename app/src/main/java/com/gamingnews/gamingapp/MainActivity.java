package com.gamingnews.gamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.gamingnews.gamingapp.databinding.ActivityMainBinding;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.api.ServiceApi;
import com.gamingnews.gamingapp.webservices.models.Item;
import com.gamingnews.gamingapp.webservices.models.Rss;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        setComponents();
        loadTestData();
    }

    private void loadTestData() {
        ServiceApi serviceApi = new ServiceApi();
        serviceApi.getEurogamerMethods().getEuroGamerData("rss", "news").enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {

                Log.d("RESPONSE CODE", response.toString());
                for (Item item: response.body().getChannel().getItems()){
                    Log.d("TITLE", item.getTitle());
                    Log.d("DESCRIPTION", item.getDescription());
                    Log.d("CREATOR", item.getCreator());
                    Log.d("Description encoded", item.getDescriptionEncoded());
                    Log.d("Image Url Media", item.getMediaImgObject().getMediaImageUrl());
                    Log.d("Image Url Enclosure", item.getEnclosureImgObject().getImageEnclosureUrl());

                }
            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    private void setComponents() {
        BottomNavigationView bottomnav = binding.bottomNavigation;
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(bottomnav, navController);
    }


}