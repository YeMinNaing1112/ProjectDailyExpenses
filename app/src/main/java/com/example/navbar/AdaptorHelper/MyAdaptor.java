package com.example.navbar.AdaptorHelper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.Pojo.DataBaseDate;
import com.example.navbar.Pojo.Database_GetData;
import com.example.navbar.Pojo.Database_GetDataFromNote;
import com.example.navbar.R;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHold> {

    private Context context;
    private ArrayList<String> name_list;
    private ArrayList<String> price_list;
    private ArrayList<String> date_list;


    public MyAdaptor(Context context, ArrayList<String> date_list) {
        this.context = context;
        this.date_list = date_list;
    }

    @NonNull
    @Override
    public MyViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first, parent, false);
        return new MyViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHold holder, int position) {
        // add date in recyclerview

        holder.date_Text.setText(date_list.get(position));


        name_list = new ArrayList<>();
        price_list = new ArrayList<>();

        Database_GetDataFromNote db = new Database_GetDataFromNote();
        db.GetDataForChildAdaptor(context, name_list, price_list, date_list.get(position));
        // creating nested recyclerview and pass user item name and price
        ChildRVAdaptor childadaptor = new ChildRVAdaptor(context, name_list, price_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(layoutManager);
        holder.recyclerView.setAdapter(childadaptor);

    }

    @Override
    public int getItemCount() {
        return date_list.size();
    }

    public class MyViewHold extends RecyclerView.ViewHolder {

        private TextView date_Text;
        private RecyclerView recyclerView;

        public MyViewHold(@NonNull View itemView) {
            super(itemView);

            date_Text = itemView.findViewById(R.id.tv_item_first);
            recyclerView = itemView.findViewById(R.id.rv_item_first);

        }
    }
}
