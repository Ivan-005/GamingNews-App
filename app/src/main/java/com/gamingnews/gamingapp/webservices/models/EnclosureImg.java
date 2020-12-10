package com.gamingnews.gamingapp.webservices.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "enclosure", strict = false)
public class EnclosureImg implements Serializable {

    @Attribute(name = "url", empty = "", required = false)
    private String imageEnclosureUrl;

    public EnclosureImg() {

    }

    public EnclosureImg(String imageEnclosureUrl) {
        this.imageEnclosureUrl = imageEnclosureUrl;
    }

    public String getImageEnclosureUrl() {
        if (imageEnclosureUrl == null) {
            imageEnclosureUrl = "";
            return imageEnclosureUrl;
        }
        return imageEnclosureUrl;
    }

    public void setImageEnclosureUrl(String imageEnclosureUrl) {
        this.imageEnclosureUrl = imageEnclosureUrl;
    }
}
