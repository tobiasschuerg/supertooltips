package com.spyhunter99.supertooltips.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.spyhunter99.supertooltips.ToolTip;
import com.spyhunter99.supertooltips.ToolTipRelativeLayout;
import com.spyhunter99.supertooltips.ToolTipView;


public class MainActivity extends Activity implements View.OnClickListener, View.OnLongClickListener {
    ToolTipRelativeLayout toolTipFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tooltip_activity).setOnClickListener(this);
        findViewById(R.id.tracker_activity).setOnClickListener(this);
        findViewById(R.id.listview_activity).setOnClickListener(this);
        findViewById(R.id.helpButtonForToolTipExample).setOnClickListener(this);
        findViewById(R.id.helpButtonForListview_activity).setOnClickListener(this);

        findViewById(R.id.tooltip_activity).setOnLongClickListener(this);
        findViewById(R.id.tracker_activity).setOnLongClickListener(this);
        findViewById(R.id.listview_activity).setOnLongClickListener(this);

        toolTipFrameLayout = (ToolTipRelativeLayout) findViewById(R.id.activity_main_tooltipframelayout);
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
                ToolTip toolTipWithText = ToolTipFactory.getToolTipWithText(this, "A demo of using sequences for tooltip hints");
                ToolTipView toolTipView = toolTipFrameLayout.showToolTipForView(toolTipWithText, findViewById(R.id.tracker_activity));
                toolTipFrameLayout.addToolTipView(toolTipView);
            }
            break;
            case R.id.tooltip_activity: {
                ToolTip toolTipWithText = ToolTipFactory.getToolTipWithText(this, "The standard demo activity");
                ToolTipView toolTipView = toolTipFrameLayout.showToolTipForView(toolTipWithText, findViewById(R.id.tooltip_activity));
                toolTipFrameLayout.addToolTipView(toolTipView);
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
