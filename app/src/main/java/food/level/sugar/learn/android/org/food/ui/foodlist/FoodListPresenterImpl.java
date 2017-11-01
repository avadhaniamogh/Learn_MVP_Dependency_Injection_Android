package food.level.sugar.learn.android.org.food.ui.foodlist;

import android.content.Context;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import javax.inject.Inject;

import food.level.sugar.learn.android.org.food.app.FoodSugarLevelApplication;
import food.level.sugar.learn.android.org.food.model.FoodzItem;
import food.level.sugar.learn.android.org.food.model.FoodzListResponse;
import food.level.sugar.learn.android.org.food.network.UsdaApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Amogh on 11/1/2017.
 */

public class FoodListPresenterImpl implements FoodListPresenter {

    private FoodListView view;

    @Inject
    UsdaApi usdaApi;


    public FoodListPresenterImpl(Context context) {
        ((FoodSugarLevelApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(FoodListView view) {
        this.view = view;
    }

    @Override
    public void getFoodz() {
        view.showLoading();

        usdaApi.getFoodzList().enqueue(new Callback<FoodzListResponse>() {
            @Override
            public void onResponse(Call<FoodzListResponse> call, Response<FoodzListResponse> response) {

                if (response.code() != 200) {

                    view.showErrorMessage();

                } else {

                    List<FoodzItem> foodzItemList = Stream.of(response.body().getList().getItem())
                            .filter(foodzItem -> !foodzItem.getName().contains("ERROR"))
                            .collect(Collectors.toList());

                    view.showFoodz(foodzItemList);
                }

                view.hideLoading();
            }

            @Override
            public void onFailure(Call<FoodzListResponse> call, Throwable t) {
                view.showErrorMessage();
                view.hideLoading();
            }
        });
    }
}
