package com.example.navbar.AdaptorHelper;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.Pojo.DatabaseHelper;
import com.example.navbar.R;

import java.util.ArrayList;

public class HomeAdaptor extends RecyclerView.Adapter<HomeAdaptor.MyViewHolder> {

    private Context context;
    private ArrayList<String> name_list;
    private ArrayList<String> price_list;
    private RecyclerViewCLickListener listener;

    public HomeAdaptor(Context context, ArrayList<String> name_list, ArrayList<String> price_list,RecyclerViewCLickListener listener) {
        this.context = context;
        this.name_list = name_list;
        this.price_list = price_list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_rv, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // show add item name and item price
        holder.name.setText(name_list.get(position));
        holder.price.setText(price_list.get(position));
    }

    @Override
    public int getItemCount() {
        return name_list.size();
    }

    public interface RecyclerViewCLickListener{

        void onClick(View v,int position);
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        private TextView name, price;
        AdapterView.OnItemClickListener itemClickListener;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_home_item_name);
            price = itemView.findViewById(R.id.tv_home_item_price);
            itemView.setOnLongClickListener(this);
        }


        @Override
        public boolean onLongClick(View view) {
            listener.onClick(view,getAdapterPosition());
            return false;
        }
    }


}
