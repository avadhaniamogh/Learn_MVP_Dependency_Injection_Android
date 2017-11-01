package food.level.sugar.learn.android.org.food.ui.food;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import food.level.sugar.learn.android.org.food.R;
import food.level.sugar.learn.android.org.food.model.FoodzItem;

public class FoodDetailsActivity extends AppCompatActivity {

    @Inject
    FoodPresenter presenter;

    public static final String EXTRA_FOOD_ID = "EXTRA_FOOD_ID";

    public static void launch(Context context, FoodzItem foodzItem) {
        Intent intent = new Intent(context, FoodDetailsActivity.class);
        intent.putExtra(EXTRA_FOOD_ID, foodzItem.getId());
        context.startActivity(intent);
    }

    @BindView(R.id.activity_food_name)
    TextView foodName;

    @BindView(R.id.activity_food_measure)
    TextView foodMeasure;

    @BindView(R.id.activity_food_nutrient)
    TextView foodNutrient;

    @BindView(R.id.activity_food_imageView)
    ImageView imageView;

    @BindView(R.id.activity_food_progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
    }
}
