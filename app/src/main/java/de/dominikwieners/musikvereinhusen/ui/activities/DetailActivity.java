package de.dominikwieners.musikvereinhusen.ui.activities;

import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.base.NucleusBaseAppCompatActivity;
import de.dominikwieners.musikvereinhusen.ui.presenter.DetailPresenter;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(DetailPresenter.class)
public class DetailActivity extends NucleusBaseAppCompatActivity<DetailPresenter> {

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

        costomizeToolbar();
        doBackPress();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }

    public void costomizeToolbar(){

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String contentText = getIntent().getSerializableExtra(CURRENT_POST).toString();
        String imageUrl = getIntent().getSerializableExtra(CURRENT_IMG_URL).toString();

        Glide.with(getApplicationContext())
                .load(imageUrl)
                .centerCrop()
                .into(imageView);

        detailText.setText(contentText);
    }

    public void doBackPress(){
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}
