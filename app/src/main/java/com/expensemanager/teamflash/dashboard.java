package com.expensemanager.teamflash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class dashboard extends AppCompatActivity {

    LinearLayout food_btn;

    LinearLayout transport_btn;

    LinearLayout shopping_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

    try {

        shopping_btn = findViewById(R.id.shopping_btn);

        shopping_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this, shoppingsum.class));


            }
        });

        transport_btn = findViewById(R.id.transport_btn);

        transport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this, transportsum.class));
            }
        });

        food_btn = findViewById(R.id.food_btn);

        food_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dashboard.this, foodsum.class));
            }
        });



    }
    catch(Exception e){
        Log.e("", "", e);

    }
    }

}
