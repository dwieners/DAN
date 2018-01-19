package de.dominikwieners.musikvereinhusen.ui.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.model.Post;
import de.dominikwieners.musikvereinhusen.ui.activities.DetailActivity;

/**
 * Created by dominikwieners on 16.01.18.
 */

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private final String CURRENT_POST = "arg_current_post";
    private final String CURRENT_IMG_URL = "arg_current_img_url";

    @BindView(R.id.iv_post)
    public ImageView imageView;

    @BindView(R.id.tv_post_headline)
    public TextView tvHeadline;

    @BindView(R.id.tv_post_excerpt)
    public TextView tvExcerpt;

    private Post post;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(view.getContext(), DetailActivity.class);
        intent.putExtra(CURRENT_POST, getDataForIntent().getTitle());
        intent.putExtra(CURRENT_IMG_URL, getDataForIntent().getThumbnailUrl());
        view.getContext().startActivity(intent);
    }

    public void setDataForIntent(Post post){
        this.post = post;
    }

    public Post getDataForIntent(){
        return post;
    }
}
