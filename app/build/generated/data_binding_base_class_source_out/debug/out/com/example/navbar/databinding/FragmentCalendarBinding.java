// Generated by view binder compiler. Do not edit!
package com.example.navbar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.navbar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCalendarBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final CalendarView calendarFragment;

  @NonNull
  public final FrameLayout calendarFragmentData;

  private FragmentCalendarBinding(@NonNull FrameLayout rootView,
      @NonNull CalendarView calendarFragment, @NonNull FrameLayout calendarFragmentData) {
    this.rootView = rootView;
    this.calendarFragment = calendarFragment;
    this.calendarFragmentData = calendarFragmentData;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCalendarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCalendarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_calendar_, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCalendarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.calendar_fragment;
      CalendarView calendarFragment = ViewBindings.findChildViewById(rootView, id);
      if (calendarFragment == null) {
        break missingId;
      }

      id = R.id.calendar_fragment_data;
      FrameLayout calendarFragmentData = ViewBindings.findChildViewById(rootView, id);
      if (calendarFragmentData == null) {
        break missingId;
      }

      return new FragmentCalendarBinding((FrameLayout) rootView, calendarFragment,
          calendarFragmentData);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
