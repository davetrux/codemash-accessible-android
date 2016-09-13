package com.hpe.digitalservices.accessibledemo;

/**
 * Data transfer object for assigning images and names
 *
 * Created by trux on 9/13/16.
 */
public class ClueItem {

    private int mPhoto;

    private String mName;


    public int getPhoto() {
        return mPhoto;
    }

    public void setPhotos(int photo) {
        this.mPhoto = photo;
    }

    public String getName() {
        return mName;
    }

    public void setNames(String name) {
        this.mName = name;
    }
}
