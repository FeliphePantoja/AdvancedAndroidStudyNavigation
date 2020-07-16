package com.advancedandroidstudynavigation.controller;

import android.content.Context;
import android.content.SharedPreferences;

public class UsefulFile {

    private static final String NAME_FILE = "file_app";
    private static final String KEY_LOGIN = "login";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor preferencesEditor;

    public UsefulFile(Context context) {
        this.sharedPreferences = context.getSharedPreferences(NAME_FILE, Context.MODE_PRIVATE);
    }

    public void saveLogin(boolean login) {
        this.preferencesEditor = this.sharedPreferences.edit();
        this.preferencesEditor.putBoolean(KEY_LOGIN, login);
        preferencesEditor.apply();
        this.preferencesEditor.commit();
    }

    public boolean getLogin() {
        return this.sharedPreferences.getBoolean(KEY_LOGIN, false);
    }

    public boolean cleanFile() {
        this.preferencesEditor.clear();
        this.preferencesEditor.commit();
        return true;
    }
}