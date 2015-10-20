package appening.test1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import appening.test1.eventscreen.EventScreen;
import appening.test1.infiniscroll.InfiniteScrollActivity;


public class MainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //quick and dirty way to select stuff we wrote:
    public void startActivity(View view)
    {

        Intent intent;

        if (view == findViewById(R.id.contentButton1))
        {
            //esteves' grid layout
            intent = new Intent(this, OldMainActivity.class);
        } else if (view == findViewById(R.id.contentButton2))
        {
            //simoes' infinite scroll
            intent = new Intent(this, InfiniteScrollActivity.class);
        } else if (view == findViewById(R.id.contentButton3))
        {
            //add new stuff here
            intent = new Intent(this, SwipeView_MainActv.class);
        } else if (view == findViewById(R.id.contentButton4))
        {
            //add new stuff here
            intent = new Intent(this, StaggViewMainActivity.class);
        } else if (view == findViewById(R.id.contentButton5))
        {
            //add new stuff here
            intent = new Intent(this, EventScreen.class);
        } else
            intent = null;

        startActivity(intent);
    }
}
