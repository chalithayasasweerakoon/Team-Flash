package com.example.pms1.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pms1.Entities.Food;
import com.example.pms1.R;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;
    private List<Food> foods;

    public FoodAdapter(Context context, List<Food> foods) {
        super(context, R.layout.food_detail_layout, foods);
        this.context = context;
        this.foods = foods;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.food_detail_layout,parent, false);

        TextView TextViewFoodName = view.findViewById(R.id.TextViewFoodName);
        TextViewFoodName.setText(foods.get(position).getName());

        TextView textViewFoodDateAdded = view.findViewById(R.id.textViewFoodDateAdded);
        textViewFoodDateAdded.setText("Added On : " + foods.get(position).getDateAdded());

        TextView textViewFoodDate = view.findViewById(R.id.textViewFoodDate);
        textViewFoodDate.setText( "Date                  :    " + foods.get(position).getDate());

        TextView textViewFoodDesc = view.findViewById(R.id.textViewFoodDesc);
        textViewFoodDesc.setText( "Description     :    " + foods.get(position).getDescription());

        TextView textViewFoodPrice = view.findViewById(R.id.textViewFoodPrice);
        textViewFoodPrice.setText( "Price          :  " +  foods.get(position).getPrice());

        return view;
    }
}

