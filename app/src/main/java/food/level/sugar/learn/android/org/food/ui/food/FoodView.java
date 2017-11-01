package food.level.sugar.learn.android.org.food.ui.food;

import food.level.sugar.learn.android.org.food.model.Food;

public interface FoodView {
  void showLoading();

  void hideLoading();

  void showFood(Food food);

  void showErrorMessage();
}
