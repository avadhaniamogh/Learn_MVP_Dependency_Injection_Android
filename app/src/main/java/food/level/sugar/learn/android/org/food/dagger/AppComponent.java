package food.level.sugar.learn.android.org.food.dagger;

import javax.inject.Singleton;

import dagger.Component;
import food.level.sugar.learn.android.org.food.ui.food.FoodPresenterImpl;
import food.level.sugar.learn.android.org.food.ui.foodlist.FoodListActivity;
import food.level.sugar.learn.android.org.food.ui.food.FoodDetailsActivity;
import food.level.sugar.learn.android.org.food.ui.foodlist.FoodListPresenterImpl;

/**
 * Created by Amogh on 10/27/2017.
 */

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(FoodListActivity target);

    void inject(FoodDetailsActivity foodActivity);

    void inject(FoodListPresenterImpl target);

    void inject(FoodPresenterImpl target);
}
