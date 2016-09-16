package com.hpe.digitalservices.accessibledemo;

/**
 * Data transfer object for assigning images and names
 *
 * Created by trux on 9/13/16.
 */
public class ClueItem {

    private int photoId;

    private String name;

    private String description;


    public int getPhoto() {
        return photoId;
    }

    public void setPhoto(int photo) {
        this.photoId = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
