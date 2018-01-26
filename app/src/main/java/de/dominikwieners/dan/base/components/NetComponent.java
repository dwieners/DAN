package de.dominikwieners.dan.base.components;

import javax.inject.Singleton;

import dagger.Component;
import de.dominikwieners.dan.ui.activities.main.MainActivity;
import de.dominikwieners.dan.base.modules.AppModule;
import de.dominikwieners.dan.base.modules.NetModule;


/**
 * Created by dominikwieners on 15.01.18.
 */


@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}

