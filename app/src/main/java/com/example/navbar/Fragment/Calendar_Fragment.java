package com.example.navbar.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.navbar.AdaptorHelper.NoteAdaptor;
import com.example.navbar.Fragment.NoteFragment;
import com.example.navbar.Pojo.DatabaseHelperForNote;
import com.example.navbar.Pojo.Database_GetData;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentCalendarBinding;
import com.example.navbar.databinding.FragmentNoteBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Calendar_Fragment extends Fragment {

    private FragmentCalendarBinding binding;
    private String date;
    private boolean check = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentCalendarBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        binding.calendarFragment.setOnDateChangeListener((calendarView, i, i1, i2) -> {
            date  = i2+"/"+i1+"/"+i+"";
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.calendar_fragment_data,new NoteFragment(date) ).commit();
        });

        return view;
    }
}