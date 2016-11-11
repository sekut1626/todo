package com.example.sebastian.mytodo;

/**
 * Created by sebastian on 24.10.16.
 */

public class ItemData {
    String text;
    Integer imageId;

    public ItemData(Integer imageId) {

        this.imageId = imageId;
    }


    public Integer getImageId() {
        return imageId;
    }
}
