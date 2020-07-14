package com.advancedandroidstudynavigation.views.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.advancedandroidstudynavigation.R;

/** related documentation
 * Pass data between destinations
 * https://developer.android.com/guide/navigation/navigation-pass-data
 *
 * NavHostFragment
 * https://developer.android.com/reference/androidx/navigation/fragment/NavHostFragment#findNavController(android.support.v4.app.Fragment)
 *
 * Navigate to a destination
 * https://developer.android.com/guide/navigation/navigation-navigate#java
 * **/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
