package com.spyhunter99.supertooltips.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.spyhunter99.supertooltips.ToolTipManager;

/**
 * created on 1/7/2017.
 *
 * @author Alex O'Ree
 */

public class DemoNoLayoutChanges extends Activity implements View.OnClickListener {
    ToolTipManager tooltips;

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_nolayout);
        tooltips = new ToolTipManager(this);
        findViewById(R.id.tooltip_activity).setOnClickListener(this);
        findViewById(R.id.tracker_activity).setOnClickListener(this);
        findViewById(R.id.listview_activity).setOnClickListener(this);

        findViewById(R.id.helpButtonForToolTipExample).setOnClickListener(this);
        findViewById(R.id.helpButtonForListview_activity).setOnClickListener(this);


    }

    public void onDestroy() {
        super.onDestroy();
        tooltips.onDestroy();
        tooltips = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tooltip_activity:
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A demo of using no layout changes " + v.getId()), v.getId());
                break;
            case R.id.tracker_activity:
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A demo of using no layout changes " + v.getId()), v.getId());
                break;
            case R.id.listview_activity:
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A demo of using no layout changes " + v.getId()), v.getId());
                break;
            case R.id.nolayoutchanges_activity:
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A demo of using no layout changes " + v.getId()), v.getId());
                break;
            case R.id.helpButtonForToolTipExample:
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A demo of using no layout changes " + v.getId()), v.getId());
                break;
            case R.id.helpButtonForListview_activity:
                tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A demo of using no layout changes " + v.getId()), v.getId());
                break;
        }
    }
}
