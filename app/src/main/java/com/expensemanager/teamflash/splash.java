package com.expensemanager.teamflash;
//
//
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
//
//
 public  class splash extends AppCompatActivity {
//
//    //Button start_btn;
      ImageButton fab;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//
           fab = findViewById(R.id.fab);
//
           fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(splash.this, MainActivity.class));

            }
             });
//
//
     }
//
}