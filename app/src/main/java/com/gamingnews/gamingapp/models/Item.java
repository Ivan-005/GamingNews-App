package com.gamingnews.gamingapp.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "item", strict = false)
public class Item implements Serializable {

    // Required element(Title) as all rss feed have this tag and it is necessary
    @Element(name = "title")
    private String title;

    // First type of descripion
    @Element(name = "description", required = false)
    private String description;

    // Second type of description
    @Element(name = "encoded", required = false)
    private String descriptionEncoded;

    // Creator of post
    @Element(name = "creator", required = false)
    private String postCreator;

    // First type of image
    @Element(name = "content", required = false)
    private MediaContentImage mediaImgObject;

    // Second type of image
    @Element(name = "enclosure", required = false)
    private EnclosureImg enclosureImgObject;

    public Item(){

    }

    public Item(String title, String description, String descriptionEncoded, String creator, MediaContentImage imageMediaURL, EnclosureImg enclosureImgObject) {
        this.title = title;
        this.description = description;
        this.descriptionEncoded = descriptionEncoded;
        this.postCreator = creator;
        this.mediaImgObject = imageMediaURL;
        this.enclosureImgObject = enclosureImgObject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        if (description == null) {
            description = "";
            return description;
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEncoded() {
        if (descriptionEncoded == null) {
            descriptionEncoded = "";
            return descriptionEncoded;
        }
        return descriptionEncoded;
    }

    public void setDescriptionEncoded(String descriptionEncoded) {
        this.descriptionEncoded = descriptionEncoded;
    }

    public String getCreator() {
        if (postCreator == null) {
            postCreator = "";
            return postCreator;
        }
        return postCreator;
    }

    public void setCreator(String postCreator) {
        this.postCreator = postCreator;
    }

    public MediaContentImage getMediaImgObject() {
        if (mediaImgObject == null) {
            return new MediaContentImage("");
        }
        return mediaImgObject;
    }

    public void setMediaImgObject(MediaContentImage imageMediaURL) {
        this.mediaImgObject = imageMediaURL;
    }

    public EnclosureImg getEnclosureImgObject() {
        if (enclosureImgObject == null){
            return new EnclosureImg("");
        }
        return enclosureImgObject;
    }

    public void setEnclosureImgObject(EnclosureImg enclosureImgObject) {
        this.enclosureImgObject = enclosureImgObject;
    }

}
