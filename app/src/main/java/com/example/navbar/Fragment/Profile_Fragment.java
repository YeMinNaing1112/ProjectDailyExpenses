package com.example.navbar.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navbar.Pojo.DatabaseHelper;
import com.example.navbar.Pojo.DatabaseHelperForNote;
import com.example.navbar.R;
import com.example.navbar.databinding.FragmentProfileBinding;


public class Profile_Fragment extends Fragment {
    FragmentProfileBinding binding;

    View view2;
    View view;
    AlertDialog alertDialog;
    DatabaseHelper db;

    int totalPrice;
    int uses;

    //    String encodedImage;
    public static final int REQUEST_CODE = 1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        view = binding.getRoot();

        //AlertDialog
        binding.tvProfileName.setOnClickListener(view1 -> {
            makeDialog("ChangeName");
            //Change Button
            Button btn_okay = view2.findViewById(R.id.buttonAction);
            btn_okay.setOnClickListener(view3 -> {
                EditText et_name = view2.findViewById(R.id.et_changeName);
                String name = et_name.getText().toString();
                TextView tv_view = binding.tvProfileName;
                if (!name.equals("")) {
                    tv_view.setText(name);
                    saveProfileName();
                }
                alertDialog.dismiss();

            });
            //exit button

            ImageView imageView = view2.findViewById(R.id.imageIcon);
            imageView.setOnClickListener(view32 -> {
                alertDialog.dismiss();
            });

            if (alertDialog.getWindow() != null) {
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            alertDialog.show();
        });

        binding.incomeLayout.setOnClickListener(view -> {
            makeDialog("ChangePrice");
            EditText et_name = view2.findViewById(R.id.et_changeName);
            et_name.setInputType(InputType.TYPE_CLASS_NUMBER);
            Button btn_okay = view2.findViewById(R.id.buttonAction);
            btn_okay.setOnClickListener(view3 -> {

                String price = et_name.getText().toString();
                TextView tv_view = binding.tvPrice;

                if (!price.equals("")) {
                    tv_view.setText(price);
                    saveMoney();
                }
                alertDialog.dismiss();


            });
            //exit button

            ImageView imageView = view2.findViewById(R.id.imageIcon);
            imageView.setOnClickListener(view32 -> {
                alertDialog.dismiss();
            });

            if (alertDialog.getWindow() != null) {
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            }
            alertDialog.show();
        });
        showData();

        showExpenses();
        showBalance();


        return view;
    }

    private void showBalance() {
        String balance = "0";
        balance = String.valueOf(totalPrice - uses);
        binding.tvBalance.setText(balance);
    }

    private void showExpenses() {
        DatabaseHelperForNote db = new DatabaseHelperForNote(getContext());
        String data = db.getData();
        uses = Integer.parseInt(data);
        binding.tvDailyExpense.setText(data);

    }


    private void saveMoney() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText et_name;
        et_name = view2.findViewById(R.id.et_changeName);
        String changePrice = et_name.getText().toString();
        int price = Integer.parseInt(changePrice);
        editor.putInt("Price", price);
//       editor.putString("ImageData",encodedImage);
        editor.commit();
        Toast.makeText(getActivity().getApplicationContext(), "SaveComplete", Toast.LENGTH_SHORT).show();


    }

    private void showData() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("Name", "User");
        int lPrice = sharedPreferences.getInt("Price", 0);
        String price = String.valueOf(lPrice);
        totalPrice = sharedPreferences.getInt("Price", 0);
        binding.tvProfileName.setText(name);
        binding.tvPrice.setText(price);
    }

    private void saveProfileName() {
        SharedPreferences sharedPreferences = getActivity()
                .getSharedPreferences("MyFile", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        EditText et_name;
        et_name = view2.findViewById(R.id.et_changeName);
        String name = et_name.getText().toString();
        editor.putString("Name", name);

        editor.commit();
        Toast.makeText(getActivity().getApplicationContext(), "SaveComplete", Toast.LENGTH_SHORT).show();
    }

    private void makeDialog(String tile) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        view2 = LayoutInflater.from(getContext()).inflate(
                R.layout.layout_success_dailog,
                (ConstraintLayout) view.findViewById(R.id.layoutDialogContainer)
        );

        builder.setView(view2);

        ((TextView) view2.findViewById(R.id.textTitle)).setText(tile);
        ((Button) view2.findViewById(R.id.buttonAction)).setText("Okay");
        ((ImageView) view2.findViewById(R.id.imageIcon)).setImageResource(R.drawable.done);

        alertDialog = builder.create();

    }

}
