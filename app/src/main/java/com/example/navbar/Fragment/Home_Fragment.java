package com.example.navbar.Fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.navbar.AdaptorHelper.HomeAdaptor;

import com.example.navbar.Pojo.DatabaseHelper;
import com.example.navbar.Pojo.DatabaseHelperForNote;
import com.example.navbar.Pojo.Database_GetData;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentEditBinding;
import com.example.navbar.databinding.FragmentHomeBinding;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {

    private ArrayList<String> name_list;
    private ArrayList<String> price_list;
    private boolean check = true;
    private FragmentHomeBinding binding;
    private HomeAdaptor.RecyclerViewCLickListener listener;
    String name;
    String price;
    int uses;
    int totalPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//       vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // Inflate the layout for this fragment
        binding=FragmentHomeBinding.inflate(inflater,container, false);
        View view = binding.getRoot();

        binding.rvHomeFragment.setHasFixedSize(true);
        binding.rvHomeFragment.setLayoutManager(new LinearLayoutManager(getContext()));
        name_list = new ArrayList<>();
        price_list = new ArrayList<>();


        // add data from SQLite database to arraylist
        Database_GetData db = new Database_GetData();
        db.displayName(getContext(), name_list, price_list, check);

        // if data exist in database it will show the recyclerview
        if (check) {
            setOnClickListener();
            HomeAdaptor adaptor = new HomeAdaptor(getContext(), name_list, price_list, listener);
            binding.rvHomeFragment.setAdapter(adaptor);
        }
        // if not, it will return a plain text

showExpenses();

        showBalance();
        return view;
    }


    private void showExpenses() {
        DatabaseHelperForNote db = new DatabaseHelperForNote(getContext());
        String data = db.getData();
        uses = Integer.parseInt(data);

    }

    private void showBalance() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        totalPrice = sharedPreferences.getInt("Price", 0);
        String balance = "0";
        balance = String.valueOf(totalPrice - uses);
        binding.tvHomeBalance.setText(balance);
    }
    public void setOnClickListener() {

        listener = (v, position) -> {
            name = name_list.get(position);
            price = price_list.get(position);
            usePopup(v);
        };
    }

    public void usePopup(View v) {
        PopupMenu popupMenu = new PopupMenu(getContext(), v);
        popupMenu.getMenuInflater().inflate(R.menu.edit_delete, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.edit:
                        showDialog(name);
                        Toast.makeText(getContext(), name+ " is edited", Toast.LENGTH_SHORT).show();

                        return true;
                    case R.id.delete:
                        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
                        databaseHelper.deleteItem(name);
                        refresh();
                        Toast.makeText(getContext(), name +" is deleted", Toast.LENGTH_LONG).show();
                        return true;
                    default:
                        return false;
                }

            }
        });
        popupMenu.show();
    }

    public void refresh(){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_main, new Home_Fragment()).commit();

    }

    public void  showDialog(String name){
        AlertDialog.Builder builder= new AlertDialog.Builder(getContext());
        LayoutInflater layoutInflater= LayoutInflater.from(getContext());
        FragmentEditBinding binding=FragmentEditBinding.inflate(layoutInflater);
        builder.setView(binding.getRoot());
        Dialog dialog= builder.create();
        dialog.show();
        binding.etEditItemName.setText(name);
        binding.etEditItemPrice.setText(price);
        binding.btSaveEditFragment.setOnClickListener(view -> {
            String item_name = binding.etEditItemName.getText().toString().trim();
            String item_price = binding.etEditItemPrice.getText().toString().trim();
            DatabaseHelper databaseHelper=new DatabaseHelper(getContext());

            databaseHelper.update(name, item_name, item_price);
            binding.etEditItemName.setText("");
           binding.etEditItemPrice.setText("");
           refresh();
            dialog.dismiss();
            Toast.makeText(getContext(), "Edit Complete", Toast.LENGTH_SHORT).show();

        });
        //Cancel
        binding.btCancelEditFragment.setOnClickListener(view -> {
            dialog.dismiss();
        });
    }

}