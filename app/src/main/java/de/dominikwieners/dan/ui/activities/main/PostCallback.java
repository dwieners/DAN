package de.dominikwieners.dan.ui.activities.main;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import de.dominikwieners.dan.model.Post;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dominikwieners on 21.01.18.
 */

public class PostCallback implements Callback<List<Post>> {

    private Context context;
    private PostRecycler recyclerView;
    private ProgressBar progressBar;

    public PostCallback(Context context, PostRecycler recyclerView, ProgressBar progressBar) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.progressBar = progressBar;
    }

    @Override
    public void onResponse(retrofit2.Call<List<Post>> call, Response<List<Post>> response) {
        progressBar.setVisibility(View.GONE);
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
