package de.dominikwieners.musikvereinhusen.model;

import com.google.gson.annotations.SerializedName;

import de.dominikwieners.musikvereinhusen.ui.activities.PostIntentData;

/**
 * Created by dominikwieners on 18.01.18.
 */

public class Post implements PostIntentData {

    @SerializedName("albumId")
    int ablumId;

    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    public Post(int ablumId, int id, String title, String thumbnailUrl) {
        this.ablumId = ablumId;
        this.id = id;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAblumId() {
        return ablumId;
    }

    public void setAblumId(int ablumId) {
        this.ablumId = ablumId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
