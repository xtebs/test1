package appening.test1.eventscreen;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import appening.test1.eventscreen.SelfLoadingGalleryItem;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Ze on 30/09/2015.
 */
public class SimpleEventItemAdapter extends ArrayAdapter<SelfLoadingGalleryItem>
{
    protected Context context;

    public SimpleEventItemAdapter(Context context)
    {
        super(context, -1, new ArrayList<SelfLoadingGalleryItem>());
        this.context = context;
    }

    public SimpleEventItemAdapter(Context context, List<SelfLoadingGalleryItem> values)
    {
        super(context, -1, values);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return this.getItem(position).createView(context, convertView, parent);

    }
}
