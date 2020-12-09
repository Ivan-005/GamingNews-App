package com.gamingnews.gamingapp.webservices.models;

import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "rss", strict = false)
public class Rss implements Serializable {
    private String title;


}
