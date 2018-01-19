package de.dominikwieners.musikvereinhusen.ui.adapter;

import android.content.Context;
import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.model.Post;
import de.dominikwieners.musikvereinhusen.repository.RestApi;
import de.dominikwieners.musikvereinhusen.ui.viewholder.PostViewHolder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by dominikwieners on 16.01.18.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private Context context;
    private List<Post> postList;

    public PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = postList.get(position);

        holder.tvExcerpt.setText(post.getTitle());
        Glide.with(context)
                .load(post.getThumbnailUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(holder.imageView);

        holder.setDataForIntent(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


}
