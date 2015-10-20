package appening.test1.eventscreen;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import appening.test1.R;
import appening.test1.eventscreen.eventlist.EventListFragment;
import appening.test1.eventscreen.gallery.ImageGalleryFragment;
import appening.test1.util.ToDo;

@ToDo("Make this class a Fragment instead of an activity")
public class EventScreen extends FragmentActivity implements ImageGalleryFragment.OnFragmentInteractionListener, EventListFragment.OnFragmentInteractionListener
{
    private static ExecutorService threadPool;

    public static ExecutorService getThreadPool()
    {
        return threadPool;
    }

    static
    {
        threadPool = Executors.newFixedThreadPool(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_screen);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.gallery_container) != null)
        {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null)
            {
                return;
            }
            // Create a new Fragment to be placed in the activity layout
            ImageGalleryFragment firstFragment = ImageGalleryFragment.newInstance(null, null);

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.add(R.id.gallery_container, firstFragment);
            tx.commit();
        }
        if (findViewById(R.id.event_list_container) != null)
        {
            if (savedInstanceState != null)
            {
                return;
            }
            EventListFragment secondFragment = EventListFragment.newInstance(null, null);
            secondFragment.setArguments(getIntent().getExtras());

            FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
            tx.add(R.id.event_list_container, secondFragment);
            tx.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_screen, menu);
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

    @Override
    public void onFragmentInteraction(Uri uri)
    {
        // Do stuff later
        Toast.makeText(this, "No Frag-Activ interaction yet", Toast.LENGTH_SHORT);
    }
}
