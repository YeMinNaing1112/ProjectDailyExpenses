package com.example.navbar;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.navbar.Fragment.AddFragment;
import com.example.navbar.Fragment.Calendar_Fragment;
import com.example.navbar.Fragment.History_Fragment;
import com.example.navbar.Fragment.Home_Fragment;
import com.example.navbar.Fragment.Profile_Fragment;
import com.example.navbar.Pojo.DatabaseHelper;
import com.example.navbar.databinding.ActivityMainBinding;
import com.example.navbar.databinding.FragmentAddBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FragmentAddBinding addBinding;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new Home_Fragment());

        // navigation bar
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bnbMenuHome:
                    replaceFragment(new Home_Fragment());
                    break;

                case R.id.bmbMenuCalender:
                    replaceFragment(new Calendar_Fragment());
                    break;

                case R.id.bnbMenuHistory:
                    replaceFragment(new History_Fragment());
                    break;

                case R.id.bnbMenuAccount:
                    replaceFragment(new Profile_Fragment());
                    break;

                default:
            }
            return true;
        });

        // move to add_fragment when user clicked floating action button
        binding.fabHome.setOnClickListener(view -> {
//            replaceFragment(new AddFragment());
            showAlertDialog();
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        addBinding = FragmentAddBinding.inflate(layoutInflater);
        builder.setView(addBinding.getRoot());

        Dialog dialog = builder.create();
        dialog.show();
        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        addBinding.btSaveAddFragment.setOnClickListener(view -> {
//            Toast.makeText(this, "Okay pr", Toast.LENGTH_SHORT).show();
            String item_name = addBinding.etItemName.getText().toString().trim();
            String item_price = addBinding.etItemPrice.getText().toString().trim();
            databaseHelper.insertCategory(item_name, item_price);

            addBinding.etItemName.setText("");
            addBinding.etItemPrice.setText("");
            refresh();
            dialog.dismiss();

        });
        //Cancel
        addBinding.btCancelAddFragment.setOnClickListener(view -> {
            dialog.dismiss();
        });
    }
    public void refresh(){
        getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_main, new Home_Fragment()).commit();

    }



    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_main, fragment).commit();
    }
}