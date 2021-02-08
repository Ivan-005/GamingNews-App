package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.RequestsApi;


public class ServiceApi {

    public static ServiceApi instance;

    public ServiceApi() {
    }

    public static ServiceApi getInstance() {
        if (instance == null) {
            instance = new ServiceApi();
        }
        return instance;
    }


    public RequestsApi getEurogamerMethods() {
        return Service.getClient(Common.EUROGAMERURL).create(RequestsApi.class);
    }

    public RequestsApi getRealSportMethods() {
        return Service.getClient(Common.REALSPORTURL).create(RequestsApi.class);
    }

    public RequestsApi getIgnMethods() {
        return Service.getClient(Common.IGNURL).create(RequestsApi.class);
    }

    public RequestsApi getGamezoneMethods() {
        return Service.getClient(Common.GAMEZONEURL).create(RequestsApi.class);
    }

    public RequestsApi getGamespotMethods() {
        return Service.getClient(Common.GAMESPOTURL).create(RequestsApi.class);
    }


}

