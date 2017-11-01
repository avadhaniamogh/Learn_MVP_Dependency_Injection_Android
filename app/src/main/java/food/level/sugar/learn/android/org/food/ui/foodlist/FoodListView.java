package food.level.sugar.learn.android.org.food.ui.foodlist;

import java.util.List;

import food.level.sugar.learn.android.org.food.model.FoodzItem;

/**
 * Created by Amogh on 11/1/2017.
 */

public interface FoodListView {

    void showLoading();

    void hideLoading();

    void showFoodz(List<FoodzItem> foodzItemList);

    void showErrorMessage();

    void launchFoodDetail(FoodzItem foodzItem);
}
