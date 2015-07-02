package appening.test1.infiniscroll;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import appening.test1.R;


public class InfiniteScrollActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_scroll_listener);

        /* TODO
         *  - Implement the following code on an Async Loader (maybe?) so the user doesn't see a blank screen while all this is loading
         *  - OnCLickListener takes user to event details
         */

        //InfiniScroll:
        GridView gridView = (GridView) findViewById(R.id.eventGallery);
        // Attach the listener to the AdapterView onCreate

        int pageSize = 5;
        //this loader is passed to the ScrollListener and is used to load the initial data. Refactor later.
        final DataLoader dataLoader = new DataLoader<EventHeaderInfo>(pageSize);
        dataLoader.setData(getPresetData(pageSize));

        //load page 0
        final List<EventHeaderInfo> adapterData = dataLoader.loadPage(0);
        final EventArrayAdapter adapter = new EventArrayAdapter(this, adapterData);
        gridView.setAdapter(adapter);

        InfiniteScrollListener listener =
                new InfiniteScrollListener()
                {
                    DataLoader<EventHeaderInfo> loader = dataLoader;

                    @Override
                    public void loadMore(int page, int totalItemsCount)
                    {
                        Log.d("ScrollListener", "Requesting more data. Page: " + page + ". Current adapter data size: " + adapter.getCount());
                        /* TODO
                         * Use Async Loader
                         */
                        // Triggered only when new data needs to be appended to the list
                        // Add whatever code is needed to append new items to your AdapterView

                        List<EventHeaderInfo> newData = loader.loadPage(page);
                        adapterData.addAll(newData);
                        adapter.notifyDataSetChanged();
                    }
                };

        gridView.setOnScrollListener(listener);

        //Content Details:
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(getApplicationContext(),
                        "Nope, that's all you get for now :) My position in the AdapterView is " + position, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    protected List<List<EventHeaderInfo>> getPresetData(int pageSize)
    {
        List<List<EventHeaderInfo>> presetData = new ArrayList<List<EventHeaderInfo>>();

        String[] content = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile", "Banana", "Apple",
                "Potato", "Grapes", "Dogs", "Cats", "Boogie", "Drop", "Shuffle"};

        List<EventHeaderInfo> page = null;
        for (int i = 0; i < content.length; i++)
        {
            //add the last page and create a new one if we reached <dataPageSize> items
            if (i % pageSize == 0)
            {
                if (i != 0)
                {
                    //add the last filled page, except if this is the first one (i==0).
                    presetData.add(page);
                }
                page = new ArrayList<>();
            }

            EventHeaderInfo e = new EventHeaderInfo(
                    getResources().getDrawable(R.drawable.hairy),
                    "Title " + i + ":" + content[i],
                    "Descr: " + "This is a Hairy Guy! I needed to test a long string for a " +
                            "description. Also this guy hasn't had a shower in three months " +
                            "and has 4 dogs and a flute which he insists on playing at " +
                            "4am because that's what he did when he visited Laos and lived as a " +
                            "shamanic guru on the jungle (the mighty jungle!) for 4 years and 4 days.");

            page.add(e);

            //last page may have less than <dataPageSize> items. In this case we need to add it manually:
            if ( /*last item?*/(i == content.length - 1) && /*doesn't fill a whole page?*/ (i % pageSize != 0))
            {
                presetData.add(page);
            }
        }
        return presetData;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_infinite_scroll_listener, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
