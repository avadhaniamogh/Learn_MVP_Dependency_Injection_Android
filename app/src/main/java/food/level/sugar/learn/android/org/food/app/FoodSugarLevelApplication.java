package food.level.sugar.learn.android.org.food.app;

import android.app.Application;

import food.level.sugar.learn.android.org.food.dagger.AppComponent;
import food.level.sugar.learn.android.org.food.dagger.AppModule;
import food.level.sugar.learn.android.org.food.dagger.DaggerAppComponent;

public class FoodSugarLevelApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(Application application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }
}
