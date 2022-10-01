package com.example.navbar.Fragment;

import android.opengl.Visibility;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.navbar.AdaptorHelper.NoteAdaptor;
import com.example.navbar.Pojo.DatabaseHelperForNote;
import com.example.navbar.Pojo.Database_GetData;
import com.example.navbar.Pojo.Database_GetDataFromNote;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentNoteBinding;

import java.util.ArrayList;

public class NoteFragment extends Fragment {

    private FragmentNoteBinding binding;
    private String date;
    private ArrayList<String> name_list,price_list,data;
    private boolean check = true;
    public NoteFragment(String date) {
        this.date = date;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNoteBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //check data from SQLite if it's exist or not
        Database_GetDataFromNote db = new Database_GetDataFromNote();
        boolean dd = db.checkData(getContext(), date);

        //check data from SQLite if it's exist or not
        if (dd){
            RV_Note();
        }
        else {
            // if not it will show the blank text
            binding.rvNote.setVisibility(View.GONE);
            binding.addNoteFragment.setVisibility(View.VISIBLE);
            binding.addNoteFragment.setOnClickListener(view1 -> {
                RV_Note();
            });
        }

        return view;

    }

    private void RV_Note(){
        Database_GetData database_getData = new Database_GetData();
        binding.addNoteFragment.setVisibility(View.GONE);
        binding.rvNote.setVisibility(View.VISIBLE);
        binding.rvNote.setHasFixedSize(true);
        binding.rvNote.setLayoutManager(new LinearLayoutManager(getContext()));
        name_list = new ArrayList<>();
        price_list = new ArrayList<>();
        database_getData.displayNameForCalander(getContext(), name_list, price_list);
        NoteAdaptor adaptor = new NoteAdaptor(getContext(), name_list, price_list, date);
        binding.rvNote.setAdapter(adaptor);
    }


}