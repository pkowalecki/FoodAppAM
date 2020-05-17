package pl.kowalecki.zad4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FoodCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar myToolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolBar);


        ArrayAdapter<Food> listAdapter = new ArrayAdapter<Food>(this,
                android.R.layout.simple_list_item_1,
                Food.foodArray);
        ListView listFood = (ListView) findViewById(R.id.list_food);
        listFood.setAdapter(listAdapter);

        AdapterView.OnItemClickListener itemClickListener =
            new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> listDrinks,
                                        View itemView,
                                        int position,
                                        long id) {
                    Intent intent = new Intent(FoodCategoryActivity.this,
                            FoodActivity.class);
                    intent.putExtra(FoodActivity.EXTRA_FOODNO, (int) id);
                    startActivity(intent);
                }
            };
        listFood.setOnItemClickListener(itemClickListener);
    }

}
