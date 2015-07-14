package appening.test1.infiniscroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import appening.test1.R;

/**
 * Created by Ze on 02/07/2015.
 */
public class EventArrayAdapter extends ArrayAdapter<EventHeaderInfo>
{
    public static final int VIEW_TYPE_LOADING = 0;
    public static final int VIEW_TYPE_ACTIVITY = 1;

    private final Context context;
    private final List<EventHeaderInfo> values;

    public EventArrayAdapter(Context context, List<EventHeaderInfo> values)
    {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item_appening, parent, false);

        ImageView img = (ImageView) rowView.findViewById(R.id.imageView);
        TextView title = (TextView) rowView.findViewById(R.id.titleText);
        TextView descr = (TextView) rowView.findViewById(R.id.descriptionText);
       // Drawable squar = (Drawable) rowView.findViewById(R.id.square_background);

        //this is a test
        if (position % 3 == 0)
        {
            descr.setText(values.get(position).getDescription());
        } else
        {
            descr.setText(values.get(position).getDescription().substring(0, 40) + "...");
        }

        title.setText(values.get(position).getTitle());
        img.setImageDrawable(values.get(position).getImage());

        // change the icon for Windows and iPhone

        return rowView;
    }
}