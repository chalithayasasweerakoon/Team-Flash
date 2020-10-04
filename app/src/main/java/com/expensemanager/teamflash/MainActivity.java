package com.expensemanager.teamflash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import Database.FoodDB;
import Database.ShoppingDB;
import Database.TransportDB;

public class MainActivity extends AppCompatActivity {

    ImageButton fab;
    Button summary_btn;
    Button reset_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,dashboard.class));
            }
        });



        summary_btn = findViewById(R.id.summary_btn);

        summary_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,summary.class));
            }
        });



        reset_btn = findViewById(R.id.reset_btn);

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setCancelable(false);
                builder.setTitle("Confirm");
                builder.setMessage("Are You Sure You Want to Reset All?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (resetAll()) {
                            Context context = getApplicationContext();
                            CharSequence text = "All Reset Successfully !";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            startActivity(new Intent(MainActivity.this,dashboard.class));
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(getBaseContext());
                            builder.setCancelable(false);
                            builder1.setMessage("Fail");
                            builder1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                        }
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });

    }

    private boolean resetAll(){

        try {

            ShoppingDB shoppingDB = new ShoppingDB(getBaseContext());
            FoodDB foodDB = new FoodDB(getBaseContext());
            TransportDB transportDB = new TransportDB(getBaseContext());


            boolean cond1 = shoppingDB.deleteAll();
            boolean cond2 = foodDB.deleteAll();
            boolean cond3 = transportDB.deleteAll();

            if (cond1 == true && cond2 == true && cond3 == true )
                return true;
            else
                return false;
        }catch (Exception e){
            Log.e("", "", e);
        }
        return true;
    }
}
