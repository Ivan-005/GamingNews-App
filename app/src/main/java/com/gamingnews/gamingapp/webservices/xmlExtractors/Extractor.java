package com.gamingnews.gamingapp.webservices.xmlExtractors;

import java.util.ArrayList;
import java.util.List;

public class Extractor {

    private static final String TAG = "EXTRACTED CODE";

    private String htmlTag;
    private String data;

    public Extractor(String htmlTag, String data) {
        this.htmlTag = htmlTag;
        this.data = data;
    }

    public List<String> extractData() {
        List<String> result = new ArrayList<>();
        String[] splitXml = data.split(htmlTag + "\"");

        return result;
    }

}
