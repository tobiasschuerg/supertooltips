package com.spyhunter99.supertooltips;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import com.spyhunter99.supertooltips.exception.ViewNotFoundRuntimeException;

/**
 * created on 1/7/2017.
 *
 * @author Alex O'Ree
 */

public class ToolTipManager implements ToolTipView.OnToolTipViewClickedListener {

    public enum CloseBehavior {
        DismissCurrent,
        DismissCurrentShowNew,
        CloseImmediate,
        CloseImmediateShowNew,
    }

    public enum SameItemOpenBehavior {
        /**
         * does nothing if the same view's tooptip is opened again
         * only way to close the tooltip is click on the tooltip itself
         */
        DoNothing,
        /**
         * closes if it it's already open
         */
        Close,
    }


    protected CloseBehavior behavior = CloseBehavior.DismissCurrent;
    protected SameItemOpenBehavior sameItemOpenBehavior = SameItemOpenBehavior.Close;
    protected ToolTipView active = null;
    protected Activity act;
    View activeId = null;


    public ToolTipManager(Activity act) {
        this(act, CloseBehavior.DismissCurrent,SameItemOpenBehavior.Close);
    }

    /**
     *
     * @param act
     * @param behavior controls how tooltips close when one is open already and another one is requested
     */
    public ToolTipManager(Activity act, CloseBehavior behavior, SameItemOpenBehavior sameItemOpenBehavior) {
        if (act == null)
            throw new RuntimeException("null Activity");
        this.act = act;
        if (behavior == null)
            throw new RuntimeException("null CloseBehavior");
        this.behavior = behavior;
        if (sameItemOpenBehavior==null)
            throw new RuntimeException("null SameItemOpenBehavior");
        this.sameItemOpenBehavior = sameItemOpenBehavior;
    }

    public void setBehavior(CloseBehavior behavior){
        if (behavior == null)
            throw new RuntimeException("null behavior");
        this.behavior=behavior;
    }

    public void onDestroy() {
        closeActiveTooltip();
        act = null;
    }


    /**
     * show's a tooltip for the given view id.
     * @param tip
     * @param viewId
     * @throws ViewNotFoundRuntimeException if the id is not found by calling activity.findViewById
     */
    public void showToolTip(final ToolTip tip, final int viewId) {
        if (act==null) return;
        View viewById = act.findViewById(viewId);
        if (viewById!=null)
            showToolTip(tip, viewById);
        else
        //TODO may be we should just log this return peacefully
            throw new ViewNotFoundRuntimeException();

    }
    /**
     * show's a tooltip on the given view.
     *
     * if a tooltip is already shown for the given view, it is closed and destroyed
     *
     * if a tooltip is already shown for another view, then the behavior setting if honored.
     * @param tip
     * @param view
     */
    public void showToolTip(final ToolTip tip, final View view) {
        if (view==null){
            throw new ViewNotFoundRuntimeException();
        }
        if (tip==null)
            throw new RuntimeException("the tooltip cannot be null");


        if (active != null && activeId == view) {
            switch (sameItemOpenBehavior) {
                case Close:
                    closeActiveTooltip();
                    return;
                case DoNothing:
                    return;
            }

            return; //prevent the animations (close, then open, if its already open)
        } else if (active != null && activeId != view) {
            switch (behavior) {
                case CloseImmediate:
                    closeTooltipImmediately();
                    break;
                case CloseImmediateShowNew:
                    closeActiveTooltip();
                case DismissCurrent:
                    closeActiveTooltip();
                    return;
                case DismissCurrentShowNew:
                    closeActiveTooltip();
                    break;
            }

        }


        View viewById = view;
        if (viewById != null) {
            ToolTipView ttv = new ToolTipView(act);
            ttv.setToolTip(tip, viewById);
            act.addContentView(ttv, view.getLayoutParams());
            active = ttv;
            activeId = view;
            active.addOnToolTipViewClickedListener(this);


        }
    }

    public void closeTooltipImmediately() {
        if (active != null && active.getParent() != null) {
            ((ViewGroup) active.getParent()).removeView(active);
            active.destroy();
            active = null;
            activeId = null;

        }

    }

    public void closeActiveTooltip() {
        if (active != null && active.getParent() != null) {
            active.remove();
            //((ViewGroup)active.getParent()).removeView(active);
            active.destroy();
            active = null;
            activeId = null;

        }

    }

    @Override
    public void onToolTipViewClicked(ToolTipView toolTipView) {
        if (toolTipView == active)
            active = null;    //self destroys after this event
    }
}
