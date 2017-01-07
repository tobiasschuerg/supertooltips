package com.spyhunter99.supertooltips.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.spyhunter99.supertooltips.ToolTip;
import com.spyhunter99.supertooltips.ToolTipManager;


public class MainActivity extends Activity implements View.OnClickListener, View.OnLongClickListener {
    ToolTipManager tooltips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tooltips = new ToolTipManager(this, ToolTipManager.CloseBehavior.CloseImmediate, ToolTipManager.SameItemOpenBehavior.Close);


        findViewById(R.id.tooltip_activity).setOnClickListener(this);
        findViewById(R.id.tracker_activity).setOnClickListener(this);
        findViewById(R.id.listview_activity).setOnClickListener(this);
        findViewById(R.id.nolayoutchanges_activity).setOnClickListener(this);
        findViewById(R.id.helpButtonForToolTipExample).setOnClickListener(this);
        findViewById(R.id.helpButtonForListview_activity).setOnClickListener(this);

        findViewById(R.id.tooltip_activity).setOnLongClickListener(this);
        findViewById(R.id.tracker_activity).setOnLongClickListener(this);

        //in onCreate
        findViewById(R.id.listview_activity).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ToolTip toolTip = new ToolTip()
                    .withText("A demo for tooltips on list view items")
                    .withColor(Color.RED) //or whatever you want
                    .withAnimationType(ToolTip.AnimationType.FROM_MASTER_VIEW)
                    .withShadow();
                tooltips.showToolTip(toolTip, v);
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        tooltips.onDestroy();
        tooltips = null;
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tooltip_activity:
                intent = new Intent(this, StandardToolTipActivity.class);
                startActivity(intent);
                break;
            case R.id.tracker_activity:
                intent = new Intent(this, TrackerActivity.class);
                startActivity(intent);
                break;
            case R.id.listview_activity:
                intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                break;
            case R.id.nolayoutchanges_activity:
                intent = new Intent(this, DemoNoLayoutChanges.class);
                startActivity(intent);
                break;
            case R.id.helpButtonForToolTipExample:
                showHelpForView(R.id.tracker_activity);
                break;
            case R.id.helpButtonForListview_activity:
                showHelpForView(R.id.tooltip_activity);
                break;
        }
    }

    protected void showHelpForView(int id) {
        switch (id) {
            case R.id.tracker_activity: {
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "demo of using sequences for tooltip hints"), id);
            }
            break;
            case R.id.tooltip_activity: {
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A standard demo"), id);
            }
            break;
            case R.id.listview_activity: {
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A listview with tooltips on each item"), id);
            }
            break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.tooltip_activity: {
                showHelpForView(v.getId());
            }
            break;
            case R.id.tracker_activity: {
                showHelpForView(v.getId());
            }
            break;
            case R.id.listview_activity:
                showHelpForView(v.getId());
                break;
        }
        return true;
    }
}
