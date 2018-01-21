package de.dominikwieners.musikvereinhusen.base;

import android.app.Application;

import de.dominikwieners.musikvereinhusen.base.components.DaggerNetComponent;
import de.dominikwieners.musikvereinhusen.base.components.NetComponent;
import de.dominikwieners.musikvereinhusen.base.modules.AppModule;
import de.dominikwieners.musikvereinhusen.base.modules.NetModule;

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
