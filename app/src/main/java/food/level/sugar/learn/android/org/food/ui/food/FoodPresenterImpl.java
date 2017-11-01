package food.level.sugar.learn.android.org.food.ui.food;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import food.level.sugar.learn.android.org.food.R;
import food.level.sugar.learn.android.org.food.app.Constants;
import food.level.sugar.learn.android.org.food.app.FoodSugarLevelApplication;
import food.level.sugar.learn.android.org.food.model.Food;
import food.level.sugar.learn.android.org.food.model.FoodNutrient;
import food.level.sugar.learn.android.org.food.model.FoodResponse;
import food.level.sugar.learn.android.org.food.network.UsdaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodPresenterImpl implements FoodPresenter {

    @Inject
    UsdaApi usdaApi;

    private FoodView view;

    public FoodPresenterImpl(Context context) {
        ((FoodSugarLevelApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(FoodView view) {
        this.view = view;
    }

    @Override
    public void getFood(String foodId) {
        view.showLoading();

        usdaApi.getFoodItem(foodId).enqueue(new Callback<FoodResponse>() {
            @Override
            public void onResponse(Call<FoodResponse> call, Response<FoodResponse> response) {
                List<Food> foodList = response.body().getReport().getFoods();
                if (foodList != null && foodList.size() > 0) {
                    view.showFood(response.body().getReport().getFoods().get(0));
                } else {
                    showError();
                }
                view.hideLoading();
            }

            @Override
            public void onFailure(Call<FoodResponse> call, Throwable t) {
                showError();
                view.hideLoading();
            }
        });
    }

    @Override
    public
    @ColorRes
    int getFoodColor(Food food) {
        int colorRes = R.color.foodUnknown;

        List<FoodNutrient> nutrients = food.getNutrients();
        if (nutrients != null && nutrients.size() > 0) {
            FoodNutrient nutrient = nutrients.get(0);
            try {
                double nutrientValue = Double.parseDouble(nutrient.getValue());
                if (nutrientValue < 0) {
                    colorRes = R.color.foodUnknown;
                } else if (nutrientValue < Constants.YELLOW_LEVEL) {
                    colorRes = R.color.foodGreen;
                } else if (nutrientValue < Constants.RED_LEVEL) {
                    colorRes = R.color.foodYellow;
                } else {
                    colorRes = R.color.foodRed;
                }
            } catch (NumberFormatException e) {
                Log.e(FoodPresenterImpl.class.getSimpleName(), "Error parsing nutrient value");
            }
        }

        return colorRes;
    }

    @Override
    public
    @DrawableRes
    int getFoodImage(Food food) {
        int drawableRes = R.drawable.yellow;

        List<FoodNutrient> nutrients = food.getNutrients();
        if (nutrients != null && nutrients.size() > 0) {
            FoodNutrient nutrient = nutrients.get(0);
            try {
                double nutrientValue = Double.parseDouble(nutrient.getValue());
                if (nutrientValue < 0) {
                    drawableRes = R.drawable.yellow;
                } else if (nutrientValue < Constants.YELLOW_LEVEL) {
                    drawableRes = R.drawable.green;
                } else if (nutrientValue < Constants.RED_LEVEL) {
                    drawableRes = R.drawable.yellow;
                } else {
                    drawableRes = R.drawable.red;
                }
            } catch (NumberFormatException e) {
                Log.e(FoodPresenterImpl.class.getSimpleName(), "Error parsing nutrient value");
            }
        }

        return drawableRes;
    }

  /*
   * Private
   */

    private void showError() {
        view.showErrorMessage();
    }
}
