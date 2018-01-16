package de.dominikwieners.musikvereinhusen.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.base.MyApplication;
import de.dominikwieners.musikvereinhusen.base.NucleusBaseAppCompatActivity;
import de.dominikwieners.musikvereinhusen.model.Media;
import de.dominikwieners.musikvereinhusen.model.Post;
import de.dominikwieners.musikvereinhusen.repository.RestApi;
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

    @BindView(R.id.infoField)
    TextView textView;

    @BindView(R.id.imageView)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MyApplication) getApplication()).getNetComponent().inject(this);

        Call<List<Post>> posts = retrofit.create(RestApi.class).getPosts();

        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                textView.setText(response.body().get(0).getTitle().getRendered());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });



        Call<List<Media>> allMedia = retrofit.create(RestApi.class).getAllMedia();

        allMedia.enqueue(new Callback<List<Media>>() {
            @Override
            public void onResponse(Call<List<Media>> call, Response<List<Media>> response) {
                Glide.with(getApplicationContext()).load(response.body().get(0).getMediaImage().getUrl()).into(imageView);
            }

            @Override
            public void onFailure(Call<List<Media>> call, Throwable t) {

            }
        });
    }





    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }


}
