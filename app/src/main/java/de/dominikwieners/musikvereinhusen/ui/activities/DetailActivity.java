package de.dominikwieners.musikvereinhusen.ui.activities;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import de.dominikwieners.musikvereinhusen.R;
import de.dominikwieners.musikvereinhusen.base.NucleusBaseAppCompatActivity;
import de.dominikwieners.musikvereinhusen.ui.presenter.DetailPresenter;
import nucleus.factory.RequiresPresenter;

@RequiresPresenter(DetailPresenter.class)
public class DetailActivity extends NucleusBaseAppCompatActivity<DetailPresenter> {

    @BindView(R.id.detail_toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Hallo");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public int getLayout() {
        return R.layout.activity_detail;
    }
}
