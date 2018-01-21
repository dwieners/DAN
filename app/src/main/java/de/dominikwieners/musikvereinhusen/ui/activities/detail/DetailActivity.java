package de.dominikwieners.musikvereinhusen.ui.activities.detail;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.base.NucleusBaseAppCompatActivity;
import de.dominikwieners.musikvereinhusen.presenter.DetailPresenter;
import de.dominikwieners.musikvereinhusen.ui.view.DetailView;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(DetailPresenter.class)
public class DetailActivity extends NucleusBaseAppCompatActivity<DetailPresenter> implements DetailView{

    private final String CURRENT_POST = "arg_current_post";
    private final String CURRENT_IMG_URL = "arg_current_img_url";

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.detailText)
    TextView detailText;

    @BindView(R.id.backdrop)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String imageUrl = getIntent().getSerializableExtra(CURRENT_IMG_URL).toString();
        String contentText = getIntent().getSerializableExtra(CURRENT_POST).toString();

        costomizeToolbar(Color.TRANSPARENT, imageView, imageUrl);
        setDetailContent(contentText);
        doBackPress();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    @Override
    public void costomizeToolbar(int statusBarColor, ImageView imageView, String imageUrl){
        setSupportActionBar(toolbar);
        setStatusBarColor(statusBarColor);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setImageForToolbar(imageView, imageUrl);
    }

    public void setDetailContent(String contentText){
        detailText.setText(contentText);
    }

    protected void doBackPress(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void setStatusBarColor(int color){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
        }
    }


    private void setImageForToolbar(ImageView imageView, String imageUrl){
        Glide.with(getApplicationContext())
                .load(imageUrl)
                .centerCrop()
                .into(imageView);
    }

}
