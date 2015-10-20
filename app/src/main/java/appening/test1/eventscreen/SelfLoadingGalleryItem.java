package appening.test1.eventscreen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.URI;
import java.util.concurrent.ExecutorService;

import appening.test1.R;
import appening.test1.infiniscroll.EventInfo;
import appening.test1.util.ToDo;

/**
 * Created by Ze on 22/09/2015.
 * <p/>
 * This is a self-loading (i.e. no need for an adapter) image item for the event gallery in screen 3.
 * The loading is submitted as a task into the eventScreen's threadPool,
 * and after finalization it updates this item's and corresponding view's content.
 */
@ToDo("Use ViewStubs instead of plain Views and overlapping ProgressBars. " +
        "Read: http://developer.android.com/training/improving-layouts/loading-ondemand.html. " +
        "Also, Use Loaders instead of AsyncTasks w/ threadPool - Read: " +
        "http://codetheory.in/asynchronous-background-execution-and-data-loading-with-loaders-framework-in-android/")
public class SelfLoadingGalleryItem
{
    private Drawable image;
    private String title;
    private String description;
    private View view;
    private ContentSource<EventInfo> contentSource;
    private boolean loaded = false;
    private ExecutorService threadPool;

    protected void setLoaded(boolean loaded)
    {
        this.loaded = loaded;
    }

    class LoadEventTask extends AsyncTask<ContentSource, Void, EventInfo>
    {
        private SelfLoadingGalleryItem item;
        private View parentView;

        public LoadEventTask(SelfLoadingGalleryItem item, View parent)
        {
            this.item = item;
            this.parentView = parent;
        }

        @Override
        protected EventInfo doInBackground(ContentSource... params)
        {
            ContentSource source = params[0];
            Log.d("Async_load", "Started async job");
            EventInfo result = contentSource.load(URI.create("local"));
            Log.d("Async_load", "Finished job.");
            return result;
        }

        @Override
        protected void onPostExecute(EventInfo result)
        {
            item.updateContent(result.getImage(), result.getTitle(), result.getDescription());
            view.invalidate();
        }
    }

    //Constructor for loading dynamic data
    public SelfLoadingGalleryItem(ContentSource<EventInfo> contentSource, ExecutorService threadPool)
    {
        this.contentSource = contentSource;
        this.threadPool = threadPool;
        this.loaded = false;
    }

    public void setContentSource(ContentSource<EventInfo> source)
    {
        this.contentSource = source;
    }

    public View createView(Context context, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_appening, parent, false);
        }
        view = convertView;
        if (loaded)
        {
            setViewContent(image, title, description);
        } else
        {
            setProgressBar();
            load(convertView, threadPool);
        }
        return view;
    }

    public View getRootLayout()
    {
        return view.findViewById(R.id.list_item_root);
    }

    protected void setProgressBar()
    {
        view.findViewById(R.id.imageView).setVisibility(View.GONE);
        view.findViewById(R.id.titleText).setVisibility(View.GONE);
        view.findViewById(R.id.descriptionText).setVisibility(View.GONE);
        ProgressBar progress = (ProgressBar) view.findViewById(R.id.imageLoading);
        progress.setVisibility(View.VISIBLE);
        progress.setIndeterminate(true);
        loaded = false;
    }

    /**
     * Set this object's and its corresponding view's content.
     * IMPORTANT: Use only in UI thread - http://developer.android.com/guide/components/processes-and-threads.html#Threads
     *
     * @param d           A Drawable for the view's background
     * @param title       Event's title
     * @param description Event's description
     */
    protected void setViewContent(Drawable d, String title, String description)
    {
        ImageView img = (ImageView) view.findViewById(R.id.imageView);
        TextView titleView = (TextView) view.findViewById(R.id.titleText);
        TextView descrView = (TextView) view.findViewById(R.id.descriptionText);
        ProgressBar progress = (ProgressBar) view.findViewById(R.id.imageLoading);

        img.setVisibility(View.VISIBLE);
        titleView.setVisibility(View.VISIBLE);
        descrView.setVisibility(View.VISIBLE);
        progress.setVisibility(View.GONE);

        loaded = true;
        descrView.setText(description);
        titleView.setText(title);
        img.setImageDrawable(image);
    }

    public void updateContent(Drawable d, String title, String description)
    {
        this.image = d;
        this.title = title;
        this.description = description;

        setViewContent(d, title, description);
        view.invalidate();
    }

    public void load(View parentView, ExecutorService threadPool)
    {
        if (loaded = true)
        {
            setProgressBar();
        }
        new LoadEventTask(this, parentView).executeOnExecutor(threadPool, this.contentSource);
    }
}
