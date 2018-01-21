package de.dominikwieners.musikvereinhusen.ui.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;

import java.util.List;

import de.dominikwieners.musikvereinhusen.model.Post;
import de.dominikwieners.musikvereinhusen.ui.adapter.PostAdapter;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dominikwieners on 21.01.18.
 */

public class PostCallback implements Callback<List<Post>> {

    private Context context;
    private PostRecycler recyclerView;

    public PostCallback(Context context, PostRecycler recyclerView) {
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onResponse(retrofit2.Call<List<Post>> call, Response<List<Post>> response) {
        List<Post> posts = getPosts(response);
        PostAdapter postAdapter = getPostAdapter(posts);
        recyclerView.setPosts(context,postAdapter);
    }

    @Override
    public void onFailure(retrofit2.Call<List<Post>> call, Throwable t) {
    }

    protected List<Post> getPosts( Response<List<Post>> response){
        return  response.body();
    }

    protected PostAdapter getPostAdapter(List<Post> posts){
        return  new PostAdapter(posts);
    }
}
