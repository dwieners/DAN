package de.dominikwieners.dan.base;

import android.app.Application;

import de.dominikwieners.dan.base.components.DaggerNetComponent;
import de.dominikwieners.dan.base.components.NetComponent;
import de.dominikwieners.dan.base.modules.AppModule;
import de.dominikwieners.dan.base.modules.NetModule;

/**
 * Created by dominikwieners on 15.01.18.
 */
public class MyApplication extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/")).build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
