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
import de.dominikwieners.musikvereinhusen.ui.activities.PostIntent;
import de.dominikwieners.musikvereinhusen.ui.activities.PostIntentData;

/**
 * Created by dominikwieners on 16.01.18.
 */

public class PostViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    @BindView(R.id.iv_post)
    public ImageView imageView;

    @BindView(R.id.tv_post_headline)
    public TextView tvHeadline;

    @BindView(R.id.tv_post_excerpt)
    public TextView tvExcerpt;

    private PostIntentData post;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        PostIntent intent = new PostIntent(view.getContext(), DetailActivity.class, post);
        view.getContext().startActivity(intent);
    }
}
