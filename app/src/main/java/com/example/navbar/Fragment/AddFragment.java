package com.example.navbar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.navbar.Pojo.DatabaseHelper;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentAddBinding;
import com.example.navbar.databinding.FragmentCalendarBinding;

public class AddFragment extends Fragment {

    private FragmentAddBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentAddBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }
}