package de.dominikwieners.musikvereinhusen.repository;

import java.util.List;

import de.dominikwieners.musikvereinhusen.model.Media;
import de.dominikwieners.musikvereinhusen.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dominikwieners on 15.01.18.
 */

public interface RestApi {
    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("(posts/{id}")
    Call<Post> getPostById(@Path("id") int postId);

    @GET("media/{featured_media}")
    Call<Media> getPostThumbnail(@Path("featured_media") int media);

    @GET("media")
    Call<List<Media>> getAllMedia();
}
