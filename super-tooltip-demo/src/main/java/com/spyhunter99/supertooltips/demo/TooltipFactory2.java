package com.spyhunter99.supertooltips.demo;

import android.app.Activity;

import com.spyhunter99.supertooltips.ToolTip;
import com.spyhunter99.supertooltips.ToolTipRelativeLayout;

/**
 * created on 1/7/2017.
 *
 * @author Alex O'Ree
 */

public class TooltipFactory2 {

    protected ToolTip active=null;
    protected Activity act;
    public TooltipFactory2(Activity act) {
        if (act==null)
            throw new RuntimeException("null activity");
        this.act=act;
    }

    public void onCreate() {
        //attach our custom view to the view hierarchy

        ToolTipRelativeLayout layout = new ToolTipRelativeLayout(act);

        //act.addContentView(layout);

    }

    public void showToolTip(ToolTip tip, int viewId) {
        closeActiveTooltip();
    }

    public void closeActiveTooltip() {
        if (active!=null) {
          //TODO  active.close();
        }
    }

}
