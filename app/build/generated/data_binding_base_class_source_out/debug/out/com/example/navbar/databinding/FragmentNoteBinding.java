// Generated by view binder compiler. Do not edit!
package com.example.navbar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.navbar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNoteBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final Button addNoteFragment;

  @NonNull
  public final RecyclerView rvNote;

  private FragmentNoteBinding(@NonNull FrameLayout rootView, @NonNull Button addNoteFragment,
      @NonNull RecyclerView rvNote) {
    this.rootView = rootView;
    this.addNoteFragment = addNoteFragment;
    this.rvNote = rvNote;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNoteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_note, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add_note_fragment;
      Button addNoteFragment = ViewBindings.findChildViewById(rootView, id);
      if (addNoteFragment == null) {
        break missingId;
      }

      id = R.id.rv_note;
      RecyclerView rvNote = ViewBindings.findChildViewById(rootView, id);
      if (rvNote == null) {
        break missingId;
      }

      return new FragmentNoteBinding((FrameLayout) rootView, addNoteFragment, rvNote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}