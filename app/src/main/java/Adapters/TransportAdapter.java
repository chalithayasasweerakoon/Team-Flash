package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import Entities.*;
import com.expensemanager.teamflash.R;

import java.util.*;

public class TransportAdapter extends ArrayAdapter<Transport> {
    private Context context;
    private List<Transport> transports;

    public TransportAdapter(Context context, List<Transport> transports) {
        super(context, R.layout.transport_detail_layout, transports);
        this.context = context;
        this.transports = transports;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.transport_detail_layout,parent, false);

        TextView TextViewTransName = view.findViewById(R.id.TextViewTransName);
        TextViewTransName.setText(transports.get(position).getName());

        TextView textViewTransDateAdded = view.findViewById(R.id.textViewTransDateAdded);
        textViewTransDateAdded.setText("Added On : " + transports.get(position).getDateAdded());

        TextView textViewTransDate = view.findViewById(R.id.textViewTransDate);
        textViewTransDate.setText( "Date                  :    " + transports.get(position).getDate());

        TextView textViewTransDesc = view.findViewById(R.id.textViewTransDesc);
        textViewTransDesc.setText( "Description     :    " + transports.get(position).getDescription());

        TextView textViewTransPrice = view.findViewById(R.id.textViewTransPrice);
        textViewTransPrice.setText( "Price          :  " +  transports.get(position).getPrice());

        return view;
    }
}
