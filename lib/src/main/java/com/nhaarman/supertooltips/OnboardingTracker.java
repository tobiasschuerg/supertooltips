package com.nhaarman.supertooltips;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ryan on 10/01/2015.
 */
public class OnboardingTracker {

    private final static String DEFAULT_PREFS = "DEFAULT_PREFS";
    private final static String DISMISSED = "_DISMISSED";
    private final static int MAX_VIEWS = 3;

    private boolean show = false;
    private Context context;
    private String id;

    public OnboardingTracker (Context context, String id) {
        this.context = context;
        this.id = id;
        init();
    }

    private void init() {
        int currentCount = getTrackerCounter();
        boolean dismissed = getDismissedPref();
        show = shouldViewShow(currentCount, dismissed);
        incrementTrackerCounter(currentCount);
    }

    private boolean shouldViewShow(int currentCount, boolean dismissed) {
        if (dismissed) {
            return false;
        } else {
            return !(currentCount >= MAX_VIEWS);
        }
    }

    private int getTrackerCounter() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(id, 0);
    }

    private void incrementTrackerCounter(int currentCount) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT_PREFS, Context.MODE_PRIVATE);
        sharedPreferences.edit().putInt(id, currentCount + 1).commit();
    }

    public boolean shouldShow() {
        return show;
    }

    public void setDismissedPref(boolean dismissed) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT_PREFS, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(id + DISMISSED, dismissed).commit();
    }

    private boolean getDismissedPref() {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DEFAULT_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(id + DISMISSED, false);
    }
}
