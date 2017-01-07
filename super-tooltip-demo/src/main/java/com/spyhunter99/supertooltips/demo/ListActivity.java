package com.spyhunter99.supertooltips.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.spyhunter99.supertooltips.OnboardingTracker;
import com.spyhunter99.supertooltips.ToolTip;
import com.spyhunter99.supertooltips.ToolTipManager;
import com.spyhunter99.supertooltips.ToolTipRelativeLayout;
import com.spyhunter99.supertooltips.ToolTipView;


public class ListActivity extends Activity implements AdapterView.OnItemLongClickListener, AdapterView.OnItemClickListener {

    ToolTipManager tooltips;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        tooltips = new ToolTipManager(this);

        String[] strings = new String[]{
                "This",
                "Is",
                "A",
                "List",
                "To",
                "Demonstrate",
                "Tooltips",
                "In",
                "A",
                "ListView",
                "More content",
                "More content",
                "More content",
                "More content",
                "More content",


        };


        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.list_text, strings);

        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);
        listView.setOnItemClickListener(this);

    }

    public void onDestroy() {
        super.onDestroy();
        tooltips.onDestroy();
        tooltips = null;
    }

    /**
     * http://stackoverflow.com/a/24864536/1203182
     * @param pos
     * @param listView
     * @return
     */
    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        View item = getViewByPosition(position,listView);
        tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A standard demo long tap/click on item: " + position), item);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        View item = getViewByPosition(position,listView);
        tooltips.showToolTip(ToolTipFactory.getToolTipWithText(this, "A standard demo short tap/click on item " + position), item);

    }
}
