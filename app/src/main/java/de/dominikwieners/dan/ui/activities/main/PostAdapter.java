package de.dominikwieners.dan.ui.activities.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import de.dominikwieners.dan.R;
import de.dominikwieners.dan.model.Post;
import de.dominikwieners.dan.ui.activities.main.viewholder.PostViewHolder;

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

        holder.setPostIntentData(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }


}
