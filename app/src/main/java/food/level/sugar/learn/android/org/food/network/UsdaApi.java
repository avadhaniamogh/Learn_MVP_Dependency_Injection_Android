package food.level.sugar.learn.android.org.food.network;

import food.level.sugar.learn.android.org.food.app.Constants;
import food.level.sugar.learn.android.org.food.model.FoodResponse;
import food.level.sugar.learn.android.org.food.model.FoodzListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UsdaApi {

  @GET("ndb/list?api_key=" + Constants.API_KEY)
  Call<FoodzListResponse> getFoodzList();

  @GET("ndb/nutrients?api_key=" + Constants.API_KEY + "&nutrients=" + Constants.SUGAR_NUTRIENT)
  Call<FoodResponse> getFoodItem(@Query("ndbno") String foodId);
}
