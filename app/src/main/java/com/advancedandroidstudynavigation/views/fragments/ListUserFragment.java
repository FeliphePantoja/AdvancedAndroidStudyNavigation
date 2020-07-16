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
import androidx.navigation.Navigation;

public class ListUserFragment extends BaseFragment implements View.OnClickListener {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AppState.setComponents(new Components(true, true));
        return inflater.inflate(R.layout.fragment_list_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvListUser = view.findViewById(R.id.tvListUser);
        tvListUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tvListUser) {

            ListUserFragmentDirections.ActionListUserFragmentToUserDetailFragment navigation =
                    ListUserFragmentDirections.actionListUserFragmentToUserDetailFragment("Hello sefa args");

            Navigation.findNavController(view).navigate(navigation);

            //without sefa args
            //Bundle dice = new Bundle();
            //dice.putString(KEY_DICE, "Hello World");
            //Navigation.findNavController(view).navigate(R.id.action_listUserFragment_to_userDetailFragment, dice);

            //navigation without action
            //Navigation.findNavController(view).navigate(R.id.userDetailFragment, dice);
        }
    }
}
