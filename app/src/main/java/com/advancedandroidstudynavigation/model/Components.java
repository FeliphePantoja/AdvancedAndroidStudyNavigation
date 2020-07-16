package com.advancedandroidstudynavigation.model;

public class Components {

    private boolean appBar;
    private boolean bottomNavigation;

    public Components(boolean appBar, boolean bottomNavigation) {
        this.appBar = appBar;
        this.bottomNavigation = bottomNavigation;
    }

    public boolean getAppBar() {
        return appBar;
    }

    public void setAppBar(boolean appBar) {
        this.appBar = appBar;
    }

    public boolean getBottomNavigation() {
        return bottomNavigation;
    }

    public void setBottomNavigation(boolean bottomNavigation) {
        this.bottomNavigation = bottomNavigation;
    }
}
