package su.dreamteam.lonja.trainingdiarymvp;


import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import su.dreamteam.lonja.trainingdiarymvp.migration.Migration;

public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        RealmConfiguration configuration = new RealmConfiguration.Builder(this)
                .migration(new Migration())
                .build();
        Realm.setDefaultConfiguration(configuration);
    }
}
