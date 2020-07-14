package com.advancedandroidstudynavigation.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.advancedandroidstudynavigation.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgs;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class UserDetailFragment extends Fragment implements View.OnClickListener {

    private String dataReceived;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        assert getArguments() != null;
        this.dataReceived = UserDetailFragmentArgs.fromBundle(getArguments()).getMessageSent();

        return inflater.inflate(R.layout.fragment_user_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvUserDetail = view.findViewById(R.id.tvUserDetail);
        tvUserDetail.setOnClickListener(this);
        if (!dataReceived.isEmpty()) {
            Toast.makeText(getContext(), dataReceived, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvUserDetail) {


            NavDirections navDirections = UserDetailFragmentDirections.actionUserDetailFragmentToFormUserFragment();
            Navigation.findNavController(view).navigate(navDirections);

            //without sefa args
            //Navigation.findNavController(view).navigate(R.id.action_userDetailFragment_to_formUserFragment);

            //navigation without action
            //Navigation.findNavController(view).navigate(R.id.formUserFragment);
        }
    }

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
        //without sefa args
        //this.dataReceived = Objects.requireNonNull(args).getString(KEY_DICE);
    }
}