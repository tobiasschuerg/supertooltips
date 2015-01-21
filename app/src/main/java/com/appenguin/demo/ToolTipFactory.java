package com.appenguin.demo;

import android.content.Context;

import com.appenguin.onboarding.ToolTip;

/**
 * Created by Ryan on 21/01/2015.
 */
public class ToolTipFactory {

    public static ToolTip getToolTipWithText(Context context, String text){
        ToolTip toolTip = new ToolTip()
                .withText(text)
                .withColor(context.getResources().getColor(R.color.holo_blue))
                .withAnimationType(ToolTip.AnimationType.FROM_MASTER_VIEW)
                .withShadow();
        return toolTip;
    }
}
