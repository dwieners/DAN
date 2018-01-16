package de.dominikwieners.musikvereinhusen.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dominikwieners on 16.01.18.
 */

public class MediaImage {

    @SerializedName("rendered")
    String url;

    public MediaImage(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
