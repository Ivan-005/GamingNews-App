package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.IgnApi;


public class IgnService {

    public IgnApi getApiMethods() {
        return Service.getClient(Common.IGNURL).create(IgnApi.class);
    }
}
