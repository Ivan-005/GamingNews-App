package com.gamingnews.gamingapp.webservices.api;

import com.gamingnews.gamingapp.utils.Common;
import com.gamingnews.gamingapp.webservices.Service;
import com.gamingnews.gamingapp.webservices.requests.RealsportApi;

public class RealSportService {

    public RealsportApi getApiMethods() {
        return Service.getClient(Common.REALSPORTURL).create(RealsportApi.class);
    }
}
