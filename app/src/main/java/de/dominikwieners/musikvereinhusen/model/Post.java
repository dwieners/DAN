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

    @SerializedName("title")
    private Title title;

    @SerializedName("excerpt")
    private Excerpt excerpt;

    @SerializedName("content")
    private Content content;

    public Post(int id, int featured_media, Title title, Excerpt excerpt, Content content) {
        this.id = id;
        this.featured_media = featured_media;
        this.title = title;
        this.excerpt = excerpt;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(int featured_media) {
        this.featured_media = featured_media;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Excerpt getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(Excerpt excerpt) {
        this.excerpt = excerpt;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
