package appening.test1.infiniscroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
public class EventArrayAdapter extends ArrayAdapter<EventInfo>
{
    protected final Context context;
    protected final List<EventInfo> values;

    public EventArrayAdapter(Context context, List<EventInfo> values)
    {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    public View getView(ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.list_item_appening, parent, false);
    }

    public void setContent(View rowView, String title, String descr, Drawable drawable)
    {
        ImageView img = (ImageView) rowView.findViewById(R.id.imageView);
        TextView titleView = (TextView) rowView.findViewById(R.id.titleText);
        TextView descrView = (TextView) rowView.findViewById(R.id.descriptionText);

        descrView.setText(descr);
        titleView.setText(title);
        img.setImageDrawable(drawable);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        String title = values.get(position).getTitle();
        String descr = (position % 3 == 0) ? values.get(position).getDescription() : values.get(position).getDescription().substring(0, 40) + "...";
        Drawable draw = values.get(position).getImage();

        View rowView = getView(parent);
        setContent(rowView, title, descr, draw);

        return rowView;
    }
}