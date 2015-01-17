package com.appenguin.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;

import com.appenguin.onboarding.OnboardingTracker;
import com.appenguin.onboarding.ToolTip;
import com.appenguin.onboarding.ToolTipRelativeLayout;
import com.appenguin.onboarding.ToolTipSequence;
import com.appenguin.onboarding.ToolTipView;

public class MainActivity extends Activity implements View.OnClickListener, ToolTipView.OnToolTipViewClickedListener {

    private ToolTipView redToolTipView;
    private ToolTipView greenToolTipView;
    private ToolTipView blueToolTipView;
    private ToolTipView purpleToolTipView;
    private ToolTipView orangeToolTipView;
    private ToolTipRelativeLayout toolTipFrameLayout;
    private ToolTipSequence toolTipSequence;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolTipFrameLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipframelayout);
        findViewById(R.id.activity_main_redtv).setOnClickListener(this);
        findViewById(R.id.activity_main_greentv).setOnClickListener(this);
        findViewById(R.id.activity_main_bluetv).setOnClickListener(this);
        findViewById(R.id.activity_main_purpletv).setOnClickListener(this);
        findViewById(R.id.activity_main_orangetv).setOnClickListener(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addRedToolTipView();
            }
        }, 500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addGreenToolTipView();
            }
        }, 700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addOrangeToolTipView();
            }
        }, 900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addBlueToolTipView();
            }
        }, 1100);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addPurpleToolTipView();
            }
        }, 1300);

        OnboardingTracker sequenceTracker = new OnboardingTracker(this, "sequence").build();

        toolTipSequence = new ToolTipSequence(sequenceTracker, toolTipFrameLayout);

    }

    private void addRedToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("A beautiful Button")
                .withColor(getResources().getColor(R.color.holo_red))
                .withShadow();

        redToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_redtv));
        redToolTipView.start();
        toolTipFrameLayout.addView(redToolTipView);
    }

    private void addGreenToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("First")
                .withColor(getResources().getColor(R.color.holo_green));

        greenToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_greentv));
        toolTipSequence.addToSequence(greenToolTipView);
    }

    private void addBlueToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withText("Second")
                .withColor(getResources().getColor(R.color.holo_blue))
                .withAnimationType(ToolTip.AnimationType.FROM_TOP);

        blueToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_bluetv));
        toolTipSequence.addToSequence(blueToolTipView);
    }

    private void addPurpleToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withContentView(LayoutInflater.from(this).inflate(R.layout.custom_tooltip, null))
                .withColor(getResources().getColor(R.color.holo_purple))
                .withAnimationType(ToolTip.AnimationType.NONE);

        purpleToolTipView = toolTipFrameLayout.showToolTipForView(toolTip, findViewById(R.id.activity_main_purpletv));
        toolTipSequence.addToSequence(purpleToolTipView);
    }

    private void addOrangeToolTipView() {
        OnboardingTracker tracker = new OnboardingTracker(this, getString(R.string.tracker_first_button))
                .withFirstShow(1)
                .withLastShow(3)
                .build();

        ToolTip toolTip = new ToolTip()
                .withText("2nd to 4th Shows!")
                .withColor(getResources().getColor(R.color.holo_orange));

        orangeToolTipView = toolTipFrameLayout.showToolTipWithTracker(toolTip, findViewById(R.id.activity_main_orangetv), tracker);
        toolTipFrameLayout.addToolTipView(orangeToolTipView);
    }

    @Override
    public void onClick(final View view) {
        int id = view.getId();
        if (id == R.id.activity_main_redtv) {
            if (redToolTipView == null) {
                addRedToolTipView();
            } else {
                redToolTipView.remove();
                redToolTipView = null;
            }

        } else if (id == R.id.activity_main_greentv) {
            if (greenToolTipView == null) {
                addGreenToolTipView();
            } else {
                greenToolTipView.remove();
                greenToolTipView = null;
            }

        } else if (id == R.id.activity_main_bluetv) {
            if (blueToolTipView == null) {
                addBlueToolTipView();
            } else {
                blueToolTipView.remove();
                blueToolTipView = null;
            }

        } else if (id == R.id.activity_main_purpletv) {
            if (purpleToolTipView == null) {
                addPurpleToolTipView();
            } else {
                purpleToolTipView.remove();
                purpleToolTipView = null;
            }

        } else if (id == R.id.activity_main_orangetv) {
            if (orangeToolTipView == null) {
                addOrangeToolTipView();
            } else {
                orangeToolTipView.remove();
                orangeToolTipView = null;
            }

        }
    }

    @Override
    public void onToolTipViewClicked(final ToolTipView toolTipView) {
        if (redToolTipView == toolTipView) {
            redToolTipView = null;
        } else if (greenToolTipView == toolTipView) {
            greenToolTipView = null;
        } else if (blueToolTipView == toolTipView) {
            blueToolTipView = null;
        } else if (purpleToolTipView == toolTipView) {
            purpleToolTipView = null;
        } else if (orangeToolTipView == toolTipView) {
            orangeToolTipView = null;
        }
    }
}

