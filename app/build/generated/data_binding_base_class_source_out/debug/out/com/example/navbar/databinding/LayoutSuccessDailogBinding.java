// Generated by view binder compiler. Do not edit!
package com.example.navbar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.navbar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutSuccessDailogBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonAction;

  @NonNull
  public final EditText etChangeName;

  @NonNull
  public final ImageView imageIcon;

  @NonNull
  public final ConstraintLayout layoutDialog;

  @NonNull
  public final ConstraintLayout layoutDialogContainer;

  @NonNull
  public final TextView textTitle;

  private LayoutSuccessDailogBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonAction, @NonNull EditText etChangeName, @NonNull ImageView imageIcon,
      @NonNull ConstraintLayout layoutDialog, @NonNull ConstraintLayout layoutDialogContainer,
      @NonNull TextView textTitle) {
    this.rootView = rootView;
    this.buttonAction = buttonAction;
    this.etChangeName = etChangeName;
    this.imageIcon = imageIcon;
    this.layoutDialog = layoutDialog;
    this.layoutDialogContainer = layoutDialogContainer;
    this.textTitle = textTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutSuccessDailogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutSuccessDailogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_success_dailog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutSuccessDailogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonAction;
      Button buttonAction = ViewBindings.findChildViewById(rootView, id);
      if (buttonAction == null) {
        break missingId;
      }

      id = R.id.et_changeName;
      EditText etChangeName = ViewBindings.findChildViewById(rootView, id);
      if (etChangeName == null) {
        break missingId;
      }

      id = R.id.imageIcon;
      ImageView imageIcon = ViewBindings.findChildViewById(rootView, id);
      if (imageIcon == null) {
        break missingId;
      }

      id = R.id.layoutDialog;
      ConstraintLayout layoutDialog = ViewBindings.findChildViewById(rootView, id);
      if (layoutDialog == null) {
        break missingId;
      }

      ConstraintLayout layoutDialogContainer = (ConstraintLayout) rootView;

      id = R.id.textTitle;
      TextView textTitle = ViewBindings.findChildViewById(rootView, id);
      if (textTitle == null) {
        break missingId;
      }

      return new LayoutSuccessDailogBinding((ConstraintLayout) rootView, buttonAction, etChangeName,
          imageIcon, layoutDialog, layoutDialogContainer, textTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
