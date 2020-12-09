package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.GamezoneApi;

public class GamezoneService {

    public GamezoneApi getApiMethods() {
        return Service.getClient(Common.GAMEZONEURL).create(GamezoneApi.class);
    }
}
