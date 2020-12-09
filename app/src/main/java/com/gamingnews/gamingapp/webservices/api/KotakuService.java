package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.KotakuApi;

public class KotakuService {

    public KotakuApi getApiMethods() {
        return Service.getClient(Common.KOTAKUURL).create(KotakuApi.class);
    }
}
