package de.dominikwieners.dan.ui.activities.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import de.dominikwieners.dan.R;

/**
 * Created by dominikwieners on 21.01.18.
 */

public class PostRecycler extends RecyclerView {


    public PostRecycler(Context context) {
        super(context);
    }

    public PostRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PostRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setPosts(Context context, PostAdapter postAdapter){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        setLayoutManager(layoutManager);
        setItemAnimator(new DefaultItemAnimator());
        setAdapter(postAdapter);
        hasFixedSize();

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_from_bottom);

        setLayoutAnimation(controller);
        getAdapter().notifyDataSetChanged();
        scheduleLayoutAnimation();
    }
}
