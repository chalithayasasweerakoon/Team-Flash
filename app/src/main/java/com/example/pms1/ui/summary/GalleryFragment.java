package com.example.pms1.ui.summary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.pms1.Database.FoodDB;
import com.example.pms1.Database.ShoppingDB;
import com.example.pms1.Database.TransportDB;
import com.example.pms1.MainActivity;
import com.example.pms1.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    TextView textViewTransportSum;
    TextView textViewFoodSum;
    TextView textViewShopSum;
    TextView totSum;
    Button reset_btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        reset_btn = root.findViewById(R.id.reset_btn);

        this.textViewTransportSum = (TextView) root.findViewById(R.id.textViewTransportSum);
        textViewTransportSum.setText(String.valueOf(new TransportDB(getActivity()).findSum()));

        this.textViewFoodSum = (TextView) root.findViewById(R.id.textViewFoodSum);
        textViewFoodSum.setText(String.valueOf(new FoodDB(getActivity()).findSum()));

        this.textViewShopSum = (TextView) root.findViewById(R.id.textViewShopSum);
        textViewShopSum.setText(String.valueOf(new ShoppingDB(getActivity()).findSum()));

        Double total = new TransportDB(getActivity()).findSum();
        total += new FoodDB(getActivity()).findSum();
        total += new ShoppingDB(getActivity()).findSum();

        this.totSum = (TextView) root.findViewById(R.id.totSum);
        totSum.setText(String.valueOf(total));

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
                            Context context = getActivity();
                            CharSequence text = "All Reset Successfully !";
                            int duration = Toast.LENGTH_SHORT;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            startActivity(new Intent(getActivity(), MainActivity.class));
                        } else {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
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

        return root;

    }

    private boolean resetAll() {

        try {

            ShoppingDB shoppingDB = new ShoppingDB(getActivity());
            FoodDB foodDB = new FoodDB(getActivity());
            TransportDB transportDB = new TransportDB(getActivity());


            boolean cond1 = shoppingDB.deleteAll();
            boolean cond2 = foodDB.deleteAll();
            boolean cond3 = transportDB.deleteAll();

            if (cond1 == true && cond2 == true && cond3 == true)
                return true;
            else
                return false;
        } catch (Exception e) {
            Log.e("", "", e);
        }
        return true;
    }


}
