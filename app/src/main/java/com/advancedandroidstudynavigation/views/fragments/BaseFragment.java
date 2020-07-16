package com.advancedandroidstudynavigation.views.fragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.advancedandroidstudynavigation.NavGraphDirections;
import com.advancedandroidstudynavigation.R;
import com.advancedandroidstudynavigation.controller.UsefulFile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

public class BaseFragment extends Fragment {

    private UsefulFile usefulFile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        this.usefulFile = new UsefulFile(getActivity());
        if (!this.usefulFile.getLogin()) {
            exitUser();
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menu_exit) {
            exitUser();
        }

        return super.onOptionsItemSelected(item);
    }

    private void exitUser() {
        this.usefulFile.saveLogin(false);
        NavDirections navDirections = NavGraphDirections.actionGlobalLoginFragment();
        NavHostFragment.findNavController(this).navigate(navDirections);
    }
}