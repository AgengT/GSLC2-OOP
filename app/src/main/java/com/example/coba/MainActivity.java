package com.example.coba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ArrayList<Food> foodItems;
    private ArrayAdapter<Food> foodAdapter;
    private ListView foodListView;
    private TextView totalCaloriesTextView;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foodItems = new ArrayList<>();
        foodAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foodItems);

        foodListView = findViewById(R.id.lv_foods);
        totalCaloriesTextView = findViewById(R.id.tv_calories);
        addButton = findViewById(R.id.btn_add);

        foodListView.setAdapter(foodAdapter);

        addButton.setOnClickListener(this);
        foodListView.setOnItemClickListener(this);
    }

    private void updateTotalCalories() {
        double totalCalories = 0.0;
        for (Food foodItem : foodItems) {
            totalCalories += foodItem.getCalories();
        }
        totalCaloriesTextView.setText("Total Calories: " + totalCalories);
    }

    @Override
    public void onClick(View v) {
        if (v == addButton) {
            DialogUtility.openEntryDialog(this, (foodName, calories) -> {
                foodItems.add(new EachFood(foodName, calories));
                foodAdapter.notifyDataSetChanged();
                updateTotalCalories();
            });
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (parent == foodListView) {
            Food selectedFood = foodItems.get(position);
            Toast.makeText(MainActivity.this, selectedFood.getDetails(), Toast.LENGTH_SHORT).show();
        }
    }
}
