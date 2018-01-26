package de.dominikwieners.dan.ui.activities.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import de.dominikwieners.dan.R;
import de.dominikwieners.dan.base.MyApplication;
import de.dominikwieners.dan.base.NucleusBaseAppCompatActivity;
import de.dominikwieners.dan.model.Post;
import de.dominikwieners.dan.repository.RestApi;
import de.dominikwieners.dan.presenter.StartpagePresenter;
import nucleus.factory.RequiresPresenter;
import retrofit2.Call;
import retrofit2.Retrofit;

@RequiresPresenter(StartpagePresenter.class)
public class MainActivity extends NucleusBaseAppCompatActivity<StartpagePresenter>  {

    @Inject
    Retrofit retrofit;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recycler)
    PostRecycler recycler;

    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApplication) getApplication()).getNetComponent().inject(this);

        setSupportActionBar(toolbar);
        progress.setVisibility(View.VISIBLE);
        Call<List<Post>> posts = retrofit.create(RestApi.class).getPosts();
        PostCallback callback = new PostCallback(getApplicationContext(), recycler, progress);
        posts.enqueue(callback);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }
}
