package com.example.navbar.AdaptorHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.R;

import java.util.ArrayList;

public class ChildRVAdaptor extends RecyclerView.Adapter<ChildRVAdaptor.ChildRVViewHolder> {

    private Context context;
    private ArrayList<String> name_list;
    private ArrayList<String> price_list;

    public ChildRVAdaptor(Context context, ArrayList<String> name_list, ArrayList<String> price_list) {
        this.context = context;
        this.name_list = name_list;
        this.price_list = price_list;
    }

    @NonNull
    @Override
    public ChildRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second, parent, false);
        return new ChildRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRVViewHolder holder, int position) {
        // show item name and item price in history fragment recyclerview
        holder.textView.setText(name_list.get(position));
    }

    @Override
    public int getItemCount() {
        return name_list.size();
    }

    public class ChildRVViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ChildRVViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.tv_item_second);

        }
    }
}
