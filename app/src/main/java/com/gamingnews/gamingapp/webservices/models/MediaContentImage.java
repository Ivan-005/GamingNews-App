package com.gamingnews.gamingapp.webservices.models;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "media:content", strict = false)
public class MediaContentImage implements Serializable {

    @Attribute(name = "url", empty = "",required = true)
    private String mediaImageUrl;

    public MediaContentImage(){
    }

    public MediaContentImage(String mediaImageUrl) {
        this.mediaImageUrl = mediaImageUrl;
    }

    public String getMediaImageUrl() {
        return mediaImageUrl;
    }

    public void setMediaImageUrl(String mediaImageUrl) {
        this.mediaImageUrl = mediaImageUrl;
    }
}
