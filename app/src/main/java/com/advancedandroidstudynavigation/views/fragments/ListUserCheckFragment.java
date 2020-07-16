package com.advancedandroidstudynavigation.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.advancedandroidstudynavigation.R;
import com.advancedandroidstudynavigation.model.Components;
import com.advancedandroidstudynavigation.views.ViewModel.AppState;

import androidx.fragment.app.Fragment;
public class ListUserCheckFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppState.setComponents(new Components(true, true));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_user_check, container, false);
    }
}
