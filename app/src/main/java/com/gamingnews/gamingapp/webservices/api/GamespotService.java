package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.GamespotApi;


public class GamespotService {

    public GamespotApi getApiMethods() {
        return Service.getClient(Common.GAMESPOTURL).create(GamespotApi.class);
    }
}
