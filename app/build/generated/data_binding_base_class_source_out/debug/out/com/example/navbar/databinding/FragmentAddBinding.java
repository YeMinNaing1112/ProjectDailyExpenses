// Generated by view binder compiler. Do not edit!
package com.example.navbar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.navbar.R;
import com.google.android.material.button.MaterialButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAddBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final MaterialButton btCancelAddFragment;

  @NonNull
  public final MaterialButton btSaveAddFragment;

  @NonNull
  public final EditText etItemName;

  @NonNull
  public final EditText etItemPrice;

  private FragmentAddBinding(@NonNull FrameLayout rootView,
      @NonNull MaterialButton btCancelAddFragment, @NonNull MaterialButton btSaveAddFragment,
      @NonNull EditText etItemName, @NonNull EditText etItemPrice) {
    this.rootView = rootView;
    this.btCancelAddFragment = btCancelAddFragment;
    this.btSaveAddFragment = btSaveAddFragment;
    this.etItemName = etItemName;
    this.etItemPrice = etItemPrice;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAddBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAddBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_add, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAddBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bt_cancel_add_fragment;
      MaterialButton btCancelAddFragment = ViewBindings.findChildViewById(rootView, id);
      if (btCancelAddFragment == null) {
        break missingId;
      }

      id = R.id.bt_save_add_fragment;
      MaterialButton btSaveAddFragment = ViewBindings.findChildViewById(rootView, id);
      if (btSaveAddFragment == null) {
        break missingId;
      }

      id = R.id.et_item_name;
      EditText etItemName = ViewBindings.findChildViewById(rootView, id);
      if (etItemName == null) {
        break missingId;
      }

      id = R.id.et_item_price;
      EditText etItemPrice = ViewBindings.findChildViewById(rootView, id);
      if (etItemPrice == null) {
        break missingId;
      }

      return new FragmentAddBinding((FrameLayout) rootView, btCancelAddFragment, btSaveAddFragment,
          etItemName, etItemPrice);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
