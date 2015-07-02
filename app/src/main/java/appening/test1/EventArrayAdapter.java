package appening.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ze on 02/07/2015.
 */
public class EventArrayAdapter extends ArrayAdapter<EventHeaderInfo>
{
    private final Context context;
    private final EventHeaderInfo[] values;

    public EventArrayAdapter(Context context, EventHeaderInfo[] values)
    {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    public EventArrayAdapter(Context context, List<EventHeaderInfo> values)
    {
        super(context, -1, values);
        this.context = context;
        this.values = values.toArray(new EventHeaderInfo[values.size()]);
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

        title.setText(values[position].getTitle());
        descr.setText(values[position].getDescription());
        img.setImageDrawable(values[position].getImage());

        // change the icon for Windows and iPhone

        return rowView;
    }
}