package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.EurogamerApi;


public class EurogamerService {

    public EurogamerApi getApiMethods() {
        return Service.getClient(Common.EUROGAMERURL).create(EurogamerApi.class);
    }
}

