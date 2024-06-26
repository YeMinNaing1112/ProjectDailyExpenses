// Generated by view binder compiler. Do not edit!
package com.example.navbar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.navbar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentProfileBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final ImageView background;

  @NonNull
  public final LinearLayout incomeLayout;

  @NonNull
  public final ImageView ivAttachMoney;

  @NonNull
  public final ImageView ivMoneyOff;

  @NonNull
  public final ImageView ivMoneyOn;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView tvBalance;

  @NonNull
  public final TextView tvDailyExpense;

  @NonNull
  public final TextView tvPrice;

  @NonNull
  public final TextView tvProfileName;

  private FragmentProfileBinding(@NonNull FrameLayout rootView, @NonNull ImageView background,
      @NonNull LinearLayout incomeLayout, @NonNull ImageView ivAttachMoney,
      @NonNull ImageView ivMoneyOff, @NonNull ImageView ivMoneyOn, @NonNull ImageView ivProfile,
      @NonNull LinearLayout linearLayout2, @NonNull TextView tvBalance,
      @NonNull TextView tvDailyExpense, @NonNull TextView tvPrice,
      @NonNull TextView tvProfileName) {
    this.rootView = rootView;
    this.background = background;
    this.incomeLayout = incomeLayout;
    this.ivAttachMoney = ivAttachMoney;
    this.ivMoneyOff = ivMoneyOff;
    this.ivMoneyOn = ivMoneyOn;
    this.ivProfile = ivProfile;
    this.linearLayout2 = linearLayout2;
    this.tvBalance = tvBalance;
    this.tvDailyExpense = tvDailyExpense;
    this.tvPrice = tvPrice;
    this.tvProfileName = tvProfileName;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_profile_, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.background;
      ImageView background = ViewBindings.findChildViewById(rootView, id);
      if (background == null) {
        break missingId;
      }

      id = R.id.incomeLayout;
      LinearLayout incomeLayout = ViewBindings.findChildViewById(rootView, id);
      if (incomeLayout == null) {
        break missingId;
      }

      id = R.id.iv_attachMoney;
      ImageView ivAttachMoney = ViewBindings.findChildViewById(rootView, id);
      if (ivAttachMoney == null) {
        break missingId;
      }

      id = R.id.iv_moneyOff;
      ImageView ivMoneyOff = ViewBindings.findChildViewById(rootView, id);
      if (ivMoneyOff == null) {
        break missingId;
      }

      id = R.id.iv_moneyOn;
      ImageView ivMoneyOn = ViewBindings.findChildViewById(rootView, id);
      if (ivMoneyOn == null) {
        break missingId;
      }

      id = R.id.iv_profile;
      ImageView ivProfile = ViewBindings.findChildViewById(rootView, id);
      if (ivProfile == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.tv_balance;
      TextView tvBalance = ViewBindings.findChildViewById(rootView, id);
      if (tvBalance == null) {
        break missingId;
      }

      id = R.id.tv_dailyExpense;
      TextView tvDailyExpense = ViewBindings.findChildViewById(rootView, id);
      if (tvDailyExpense == null) {
        break missingId;
      }

      id = R.id.tv_price;
      TextView tvPrice = ViewBindings.findChildViewById(rootView, id);
      if (tvPrice == null) {
        break missingId;
      }

      id = R.id.tv_profile_name;
      TextView tvProfileName = ViewBindings.findChildViewById(rootView, id);
      if (tvProfileName == null) {
        break missingId;
      }

      return new FragmentProfileBinding((FrameLayout) rootView, background, incomeLayout,
          ivAttachMoney, ivMoneyOff, ivMoneyOn, ivProfile, linearLayout2, tvBalance, tvDailyExpense,
          tvPrice, tvProfileName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
