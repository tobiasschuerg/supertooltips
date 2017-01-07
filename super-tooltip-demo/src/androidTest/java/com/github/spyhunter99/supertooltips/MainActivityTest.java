package com.github.spyhunter99.supertooltips;

import android.test.ActivityInstrumentationTestCase2;

import com.spyhunter99.supertooltips.demo.MainActivity;
import com.spyhunter99.supertooltips.demo.R;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }


    public void testActivity() throws Throwable {
        final MainActivity activity = getActivity();
        assertNotNull(activity);


        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.helpButtonForToolTipExample).performClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.helpButtonForListview_activity).performClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.tooltip_activity).performLongClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.tracker_activity).performLongClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.listview_activity).performLongClick();
            }
        });


/*




        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.tooltip_activity).performClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.tracker_activity).performClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.listview_activity).performClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                activity.findViewById(R.id.nolayoutchanges_activity).performClick();
            }
        });

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

*/

    }
}

