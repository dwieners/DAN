package de.dominikwieners.musikvereinhusen.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dominikwieners on 15.01.18.
 */

public class Media {

    @SerializedName("post")
    private int postId;

    @SerializedName("guid")
    private MediaImage mediaImage;

    public Media(int postId, MediaImage mediaImage) {
        this.postId = postId;
        this.mediaImage = mediaImage;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public MediaImage getMediaImage() {
        return mediaImage;
    }

    public void setMediaImage(MediaImage mediaImage) {
        this.mediaImage = mediaImage;
    }
}
