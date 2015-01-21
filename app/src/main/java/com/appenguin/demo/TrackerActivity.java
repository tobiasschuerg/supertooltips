package com.appenguin.demo;

import android.app.Activity;
import android.os.Bundle;

import com.appenguin.onboarding.OnboardingTracker;
import com.appenguin.onboarding.ToolTip;
import com.appenguin.onboarding.ToolTipRelativeLayout;
import com.appenguin.onboarding.ToolTipSequence;
import com.appenguin.onboarding.ToolTipView;

public class TrackerActivity extends Activity {

    private ToolTipRelativeLayout toolTipFrameLayout;
    private ToolTipSequence toolTipSequence;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tracker_activity);

        toolTipFrameLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipframelayout);

        OnboardingTracker sequenceTracker = new OnboardingTracker(this, "sequence").build();
        toolTipSequence = new ToolTipSequence(sequenceTracker, toolTipFrameLayout);

        addRedToolTipView();
        addGreenToolTipView();
        addOrangeToolTipView();
        addBlueToolTipView();
        addPurpleToolTipView();
    }

    private void addRedToolTipView() {
        final ToolTip toolTip = ToolTipFactory.getToolTipWithText(this, "Todo");

        ToolTipView redToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_redtv));
        redToolTipView.start();
        toolTipFrameLayout.addView(redToolTipView);
    }

    private void addGreenToolTipView() {
        final ToolTip toolTip = ToolTipFactory.getToolTipWithText(this, "First");

        ToolTipView greenToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_greentv));
        toolTipSequence.addToSequence(greenToolTipView);
    }

    private void addBlueToolTipView() {
        final ToolTip toolTip = ToolTipFactory.getToolTipWithText(this, "Second");

        ToolTipView blueToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_bluetv));
        toolTipSequence.addToSequence(blueToolTipView);
    }

    private void addPurpleToolTipView() {
        final ToolTip toolTip = ToolTipFactory.getToolTipWithText(this, "Final");

        ToolTipView purpleToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_purpletv));
        toolTipSequence.addToSequence(purpleToolTipView);
    }

    private void addOrangeToolTipView() {
        OnboardingTracker tracker = new OnboardingTracker(this, getString(R.string.tracker_first_button))
                .withFirstShow(1)
                .withLastShow(3)
                .build();

        final ToolTip toolTip = ToolTipFactory.getToolTipWithText(this, "Shows on 2nd to 4th views");

        ToolTipView orangeToolTipView = toolTipFrameLayout.showToolTipWithTracker(toolTip, findViewById(R.id.activity_main_orangetv), tracker);
        toolTipFrameLayout.addToolTipView(orangeToolTipView);
    }
}

