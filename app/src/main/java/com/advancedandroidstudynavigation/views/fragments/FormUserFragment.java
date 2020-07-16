package com.advancedandroidstudynavigation.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.advancedandroidstudynavigation.R;
import com.advancedandroidstudynavigation.model.Components;
import com.advancedandroidstudynavigation.views.ViewModel.AppState;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class FormUserFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppState.setComponents(new Components(true, false));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvFormUser = view.findViewById(R.id.tvFormUser);
        tvFormUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvFormUser) {

            NavDirections navDirections = FormUserFragmentDirections.actionFormUserFragmentToListUserFragment();
            Navigation.findNavController(view).navigate(navDirections);

            //without sefa args
            //Navigation.findNavController(view).navigate(R.id.action_formUserFragment_to_listUserFragment);

            //navigation without action
            //Navigation.findNavController(view).popBackStack(R.id.listUserFragment, false);
        }
    }
}