package com.advancedandroidstudynavigation.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.advancedandroidstudynavigation.R;
import com.advancedandroidstudynavigation.controller.UsefulFile;
import com.advancedandroidstudynavigation.model.Components;
import com.advancedandroidstudynavigation.views.ViewModel.AppState;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private UsefulFile usefulFile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        AppState.setComponents(new Components(false, false));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.usefulFile = new UsefulFile(view.getContext());
        Button btAccess = view.findViewById(R.id.btAccessLogin);
        Button btRegister = view.findViewById(R.id.btRegisterUser);

        btAccess.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btAccessLogin) {
            this.usefulFile.saveLogin(true);
            navigateTo(view);
        } else if (view.getId() == R.id.btRegisterUser) {
            NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToUserRegistrationFragment();
            NavHostFragment.findNavController(this).navigate(navDirections);
        }
    }

    private void navigateTo(View view) {
        NavDirections navDirections = LoginFragmentDirections.actionLoginFragmentToListUserFragment();
        NavHostFragment.findNavController(this).navigate(navDirections);
//        Navigation.findNavController(view).navigate(navDirections);
    }
}
