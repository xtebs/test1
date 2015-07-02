package appening.test1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;


public class InfiniteScrollActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinite_scroll_listener);

        /* TODO
         *  - Implement this on a Loader (maybe?) so the user doesn't see a blank screen while all this is loading
         *  - OnCLickListener takes user to event details
         */

        //InfiniScroll:
        GridView gridView = (GridView) findViewById(R.id.gridView);
        // Attach the listener to the AdapterView onCreate
        gridView.setOnScrollListener(new InfiniteScrollListener(10)
        {
            @Override
            public void loadMore(int page, int totalItemsCount)
            {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to your AdapterView
                customLoadMoreDataFromApi(totalItemsCount);
                // or customLoadMoreDataFromApi(page);
            }
        });

        //Content Details:
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                Toast.makeText(getApplicationContext(),
                        "Nope, that's all you get for now :) My position in the AdapterView is " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

        //Content:
        String[] titles = new String[]{"Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile"};

        final ArrayList<EventHeaderInfo> list = new ArrayList<>();
        for (int i = 0; i < titles.length; ++i)
        {
            EventHeaderInfo e = new EventHeaderInfo(
                    getResources().getDrawable(R.drawable.hairy),
                    "Title " + i + ":" + titles[i],
                    "Descr: " + "This is a Hairy Guy! I needed to test a long string for a " +
                            "description. Also this guy hasn't had a shower in three months " +
                            "and has 4 dogs and a flute which he insists on playing at " +
                            "4am because that's what he did when he visited Laos and lived as a " +
                            "shamanic guru on the jungle (the mighty jungle!) for 4 years and 4 days.");
            list.add(e);
        }
        final EventArrayAdapter adapter = new EventArrayAdapter(this, list);
        gridView.setAdapter(adapter);

    }

    // Append more data into the adapter
    public void customLoadMoreDataFromApi(int offset)
    {
        // This method probably sends out a network request and appends new data items to your adapter.
        // Use the offset value and add it as a parameter to your API request to retrieve paginated data.
        // Deserialize API response and then construct new objects to append to the adapter

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
