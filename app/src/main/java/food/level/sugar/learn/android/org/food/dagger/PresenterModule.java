package food.level.sugar.learn.android.org.food.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import food.level.sugar.learn.android.org.food.ui.food.FoodPresenter;
import food.level.sugar.learn.android.org.food.ui.food.FoodPresenterImpl;
import food.level.sugar.learn.android.org.food.ui.foodlist.FoodListPresenter;
import food.level.sugar.learn.android.org.food.ui.foodlist.FoodListPresenterImpl;

/**
 * Created by Amogh on 10/28/2017.
 */

@Module
public class PresenterModule {

    @Singleton
    @Provides
    FoodListPresenter provideFoodzPresenter(Context context) {
        return new FoodListPresenterImpl(context);
    }

    @Singleton
    @Provides
    FoodPresenter provideFoodPresenter(Context context) {
        return new FoodPresenterImpl(context);
    }
}
