package de.dominikwieners.dan.base;

import android.os.Bundle;

import butterknife.ButterKnife;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

/**
 * Created by dominikwieners on 15.01.18.
 */

public abstract class NucleusBaseAppCompatActivity<P extends Presenter> extends NucleusAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
    }

    public abstract int getLayout();

}
