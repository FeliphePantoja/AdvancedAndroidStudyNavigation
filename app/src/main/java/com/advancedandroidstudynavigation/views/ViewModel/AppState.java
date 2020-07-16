package com.advancedandroidstudynavigation.views.ViewModel;

import com.advancedandroidstudynavigation.model.Components;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppState extends ViewModel {

    private final static MutableLiveData<Components> selected = new MutableLiveData<>();

    public static void setComponents(Components item) {
        selected.setValue(item);
    }

    public LiveData<Components> componentsMutableLiveData() {
        return selected;
    }
}
