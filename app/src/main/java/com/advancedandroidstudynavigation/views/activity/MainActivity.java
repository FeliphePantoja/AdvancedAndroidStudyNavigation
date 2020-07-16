package com.advancedandroidstudynavigation.views.activity;

import android.os.Bundle;
import android.view.View;

import com.advancedandroidstudynavigation.R;
import com.advancedandroidstudynavigation.model.Components;
import com.advancedandroidstudynavigation.views.ViewModel.AppState;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

/**
 * related documentation
 * Pass data between destinations
 * https://developer.android.com/guide/navigation/navigation-pass-data
 * <p>
 * NavHostFragment
 * https://developer.android.com/reference/androidx/navigation/fragment/NavHostFragment#findNavController(android.support.v4.app.Fragment)
 * <p>
 * Navigate to a destination
 * https://developer.android.com/guide/navigation/navigation-navigate#java
 * <p>
 * NavigationBottom
 * https://developer.android.com/guide/navigation/navigation-ui?hl=TR
 *
 * Share data between fragments
 * https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
 **/

public class MainActivity extends AppCompatActivity implements NavController.OnDestinationChangedListener {

    private BottomNavigationView bottomNavigationView;
    private AppState appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appState = new ViewModelProvider(this).get(AppState.class);
        this.bottomNavigationView = findViewById(R.id.main_activity_bottom_navigation);
        NavController navController = Navigation.findNavController(this, R.id.main_nav_host);
        navController.addOnDestinationChangedListener(this);
        NavigationUI.setupWithNavController(this.bottomNavigationView, navController);

    }

    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {

        this.setTitle(destination.getLabel());

        this.appState.componentsMutableLiveData().observe(this, new Observer<Components>() {
            @Override
            public void onChanged(Components components) {

                if (components != null) {

                    if (components.getBottomNavigation()) {
                        bottomNavigationView.setVisibility(View.VISIBLE);
                    } else {
                        bottomNavigationView.setVisibility(View.GONE);
                    }

                    if (components.getAppBar()) {
                        Objects.requireNonNull(getSupportActionBar()).show();
                    } else {
                        Objects.requireNonNull(getSupportActionBar()).hide();
                    }

                }
            }
        });
    }
}
