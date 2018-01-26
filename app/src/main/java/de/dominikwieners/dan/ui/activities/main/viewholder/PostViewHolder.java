package de.dominikwieners.dan.ui.activities.main.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.dominikwieners.dan.intents.PostIntent;
import de.dominikwieners.dan.R;
import de.dominikwieners.dan.ui.activities.detail.DetailActivity;
import de.dominikwieners.dan.intents.PostIntentData;

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
       // ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) view.getContext(), imageView, view.getContext().getString(R.string.shared_item_image));
       // view.getContext().startActivity(intent, activityOptionsCompat.toBundle());
        view.getContext().startActivity(intent);
    }

    public void setPostIntentData(PostIntentData postIntentData){
        this.post = postIntentData;
    }

}
