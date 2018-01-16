package de.dominikwieners.musikvereinhusen.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.model.Post;

/**
 * Created by dominikwieners on 16.01.18.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_post)
    ImageView imageView;

    @BindView(R.id.tv_post_headline)
    TextView tvHeadline;

    @BindView(R.id.tv_post_excerpt)
    TextView tvExcerpt;

    public PostViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void bindPost(Post post) {
        tvHeadline.setText(post.getTitle().getRendered());
        tvExcerpt.setText(Html.fromHtml(post.getExcerpt().getRendered()), TextView.BufferType.SPANNABLE);
    }


}
