package com.gamingnews.gamingapp.webservices.requests;

import com.gamingnews.gamingapp.webservices.models.Rss;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestsApi {

    // Fetching XML from EuroGamer
    @GET("")
    Call<Rss> getEuroGamerData(
            @Query("format") String rss,
            @Query("type") String news);

    // Fetching game news from Gamespot
    @GET("game-news")
    Call<Rss> getGamespotNews();

    // Fetching game reviews from Gamespot
    @GET("reviews")
    Call<Rss> getGamespotReviews();

    // Fetching news from GameZone
    @GET("feed")
    Call<Rss> getGamezoneNews();

    // Fetching games section from IGN
    @GET("games-all")
    Call<Rss> getIgnNews();

    // Fetching XML from RealSport
    @GET("feed.xml")
    Call<Rss> getRealsportNews();
}

