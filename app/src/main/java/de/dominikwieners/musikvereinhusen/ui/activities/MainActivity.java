package de.dominikwieners.musikvereinhusen.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.base.MyApplication;
import de.dominikwieners.musikvereinhusen.base.NucleusBaseAppCompatActivity;
import de.dominikwieners.musikvereinhusen.model.Post;
import de.dominikwieners.musikvereinhusen.repository.RestApi;
import de.dominikwieners.musikvereinhusen.ui.adapter.PostAdapter;
import de.dominikwieners.musikvereinhusen.ui.presenter.StartpagePresenter;
import nucleus.factory.RequiresPresenter;
import nucleus.view.NucleusAppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@RequiresPresenter(StartpagePresenter.class)
public class MainActivity extends NucleusBaseAppCompatActivity<StartpagePresenter> {

    @Inject
    Retrofit retrofit;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler)
    PostRecycler recycler;

    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApplication) getApplication()).getNetComponent().inject(this);

        setSupportActionBar(toolbar);

        Call<List<Post>> posts = retrofit.create(RestApi.class).getPosts();

        PostCallback callback = new PostCallback(getApplicationContext(), recycler);

        posts.enqueue(callback);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
