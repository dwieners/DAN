package de.dominikwieners.dan.repository;

import java.util.List;

import de.dominikwieners.dan.model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by dominikwieners on 15.01.18.
 */

public interface RestApi {
    @GET("photos")
    Call<List<Post>> getPosts();

}
