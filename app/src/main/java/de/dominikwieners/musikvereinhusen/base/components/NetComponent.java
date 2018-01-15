package de.dominikwieners.musikvereinhusen.base.components;

import javax.inject.Singleton;

import dagger.Component;
import de.dominikwieners.musikvereinhusen.ui.activities.MainActivity;
import de.dominikwieners.musikvereinhusen.base.modules.AppModule;
import de.dominikwieners.musikvereinhusen.base.modules.NetModule;


/**
 * Created by dominikwieners on 15.01.18.
 */


@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}

