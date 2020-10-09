package com.example.pms1.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.pms1.R;
import com.example.pms1.ui.home.food.foodsum;
import com.example.pms1.ui.home.shoppin.shoppingsum;
import com.example.pms1.ui.home.transport.transportsum;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    LinearLayout food_btn;

    LinearLayout transport_btn;

    LinearLayout shopping_btn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        try {

            shopping_btn = root.findViewById(R.id.shopping_btn);

            shopping_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), shoppingsum.class));


                }
            });

            transport_btn = root.findViewById(R.id.transport_btn);

            transport_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), transportsum.class));
                }
            });

            food_btn = root.findViewById(R.id.food_btn);

            food_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(), foodsum.class));
                }
            });


        } catch (Exception e) {
            Log.e("", "", e);

        }

        return root;
    }
}