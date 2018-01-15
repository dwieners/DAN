package de.dominikwieners.musikvereinhusen.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dominikwieners on 15.01.18.
 */

public class Post {


    @SerializedName("id")
    private int id;

    @SerializedName("featured_media")
    private int featured_media;

    public Post(int id, int featured_media) {
        this.id = id;
        this.featured_media = featured_media;
    }

    public int getId() {
        return id;
    }


    public int getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(int featured_media) {
        this.featured_media = featured_media;
    }
}
