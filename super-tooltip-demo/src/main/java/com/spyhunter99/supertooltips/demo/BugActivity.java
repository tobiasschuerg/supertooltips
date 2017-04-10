package com.spyhunter99.supertooltips.demo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.spyhunter99.supertooltips.ToolTip;
import com.spyhunter99.supertooltips.ToolTipManager;

/**
 * created on 4/10/2017.
 *
 * @author Alex O'Ree
 */

public class BugActivity extends Activity {
    ToolTipManager tooltips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug5);
        tooltips = new ToolTipManager(this, ToolTipManager.CloseBehavior.CloseImmediate, ToolTipManager.SameItemOpenBehavior.Close);

    }

    @Override
    public void onResume(){
        super.onResume();
        findViewById(R.id.bug_button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolTip toolTip = new ToolTip()
                    .withText("A demo for tooltips on list view items")
                    .withColor(Color.RED) //or whatever you want
                    .withAnimationType(ToolTip.AnimationType.FROM_MASTER_VIEW)
                    .withShadow();
                tooltips.showToolTip(toolTip, v);
                tooltips.closeActiveTooltip();

            }
        });

    }
}
