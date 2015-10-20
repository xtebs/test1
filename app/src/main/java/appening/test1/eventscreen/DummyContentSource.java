package appening.test1.eventscreen;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import appening.test1.R;
import appening.test1.infiniscroll.EventInfo;

/**
 * Dummy content source for testing.
 * This class loads all the Drawable ids from the resources and feeds them sequentially when requested.
 */
public class DummyContentSource extends ContentSource<EventInfo>
{
    private final List<Integer> drawableIds = new ArrayList<Integer>();
    private volatile int idCounter = 0;
    private final int maxDelayMillis = 2000;
    private final int minDelayMillis = 1000;
    private Context context;

    public DummyContentSource(Context context)
    {
        this.context = context;
        loadDrawableIds();
    }

    public void loadDrawableIds()
    {
        drawableIds.add(R.drawable.hairy);
        drawableIds.add(R.drawable.download1);
        drawableIds.add(R.drawable.build);

    }

    public int getSize()
    {
        return drawableIds.size();
    }

    @Override
    public EventInfo load(URI uri)
    {

        /*
        //simulate (e.g. network) delay
        try
        {
            Random r = new Random(Thread.currentThread().getId());
            //random value between minDelayMillis and maxDelayMillis:
            int millis = minDelayMillis + r.nextInt(maxDelayMillis - minDelayMillis + 1);
            Thread.sleep(millis);
        } catch (InterruptedException e)
        {
        }*/

        int drawableId;
        synchronized (drawableIds)
        {
            drawableId = drawableIds.get(idCounter);
            idCounter++;
            idCounter %= drawableIds.size();
        }
        Drawable drawable = context.getResources().getDrawable(drawableId);
        return new EventInfo(drawable, "Title", "Description: Lorem ipsum dolor sit amet.");
    }
}
