package food.level.sugar.learn.android.org.food.ui.food;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import food.level.sugar.learn.android.org.food.model.Food;

public interface FoodPresenter {
  void setView(FoodView view);

  void getFood(String foodId);

  @ColorRes
  int getFoodColor(Food food);

  @DrawableRes
  int getFoodImage(Food food);
}
