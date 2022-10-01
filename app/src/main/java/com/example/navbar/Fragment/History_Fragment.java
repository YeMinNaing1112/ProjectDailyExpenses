package com.example.navbar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navbar.AdaptorHelper.MyAdaptor;
import com.example.navbar.Pojo.DatabaseHelperForNote;
import com.example.navbar.Pojo.Database_GetData;
import com.example.navbar.Pojo.Database_GetDataFromDate;
import com.example.navbar.Pojo.Database_GetDataFromNote;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentHistoryBinding;

import java.util.ArrayList;

public class  History_Fragment extends Fragment {
    private ArrayList<String> name_list;
    private ArrayList<String> price_list;
    private ArrayList<String> date_list;
    private boolean check;
    private FragmentHistoryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentHistoryBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        // build recyclerview

       binding.rvHistory.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.rvHistory.setLayoutManager(layoutManager);
        Database_GetDataFromNote db = new Database_GetDataFromNote();

        name_list = new ArrayList<>();
        price_list = new ArrayList<>();
        date_list = new ArrayList<>();

        // check data exist in note database
        check = db.displayDate(getContext());

        // if data exist recyclerview will show
        if (check){

            // get the date list from Date database
            binding.tvHistory.setVisibility(View.GONE);
            binding.rvHistory.setVisibility(View.VISIBLE);
            Database_GetDataFromDate database_getData = new Database_GetDataFromDate();
            database_getData.displayDateFromDB(getContext(), date_list);
            MyAdaptor adaptor = new MyAdaptor(getContext(), date_list);
            binding.rvHistory.setAdapter(adaptor);

        }
        else {
            binding.rvHistory.setVisibility(View.GONE);
            binding.tvHistory.setVisibility(View.VISIBLE);
        }
        return view;
    }
}