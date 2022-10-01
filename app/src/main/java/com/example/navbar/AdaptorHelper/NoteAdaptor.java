package com.example.navbar.AdaptorHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navbar.Pojo.DataBaseDate;
import com.example.navbar.Pojo.DatabaseHelperForNote;
import com.example.navbar.Pojo.Database_GetData;
import com.example.navbar.Pojo.Database_GetDataFromDate;
import com.example.navbar.Pojo.Database_GetDataFromNote;
import com.example.navbar.R;

import java.util.ArrayList;

public class NoteAdaptor extends RecyclerView.Adapter<NoteAdaptor.MyViewHolder> {

    private Context context;
    private ArrayList<String> name_list;
    private ArrayList<String> price_list;
    private String date;
    private Database_GetDataFromNote database_getData;
    private Database_GetDataFromDate db;
    private boolean date_check;
    private ArrayList<String> date_id;

    public NoteAdaptor(Context context, ArrayList<String> name_list, ArrayList<String> price_list, String date) {
        this.context = context;
        this.name_list = name_list;
        this.price_list = price_list;
        this.date = date;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {


        date_id =  new ArrayList<>();
        database_getData = new Database_GetDataFromNote();
        boolean checking = database_getData.checkName(context, name_list.get(position), date);
        holder.name.setText(name_list.get(position));
        holder.price.setText(price_list.get(position));
        if (checking){
            holder.checkBox.setChecked(true);
        }
        else {
            holder.checkBox.setChecked(false);
        }

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){

                    db = new Database_GetDataFromDate();
                    date_check = db.checkDateFromDatabase(context, date);

                    if (date_check){

                        AddData(position);

                    }
                    else {
                        DataBaseDate db_database = new DataBaseDate(context);
                        db_database.insertDataToDate(date);
                        AddData(position);
                    }

                }
                else {
                    DatabaseHelperForNote databaseHelperForNote = new DatabaseHelperForNote(context);
                    databaseHelperForNote.deleteData(name_list.get(position), date);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return name_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_note_item_name);
            price = itemView.findViewById(R.id.tv_note_item_price);
            checkBox = itemView.findViewById(R.id.cb_note);

        }
    }

   public void AddData(int position){
       DatabaseHelperForNote db_note = new DatabaseHelperForNote(context);
       db.Checking_NotewithDateID(context, date_id);
       db_note.insertDataToNote(name_list.get(position), price_list.get(position), date, date_id.get(0));
   }

}
