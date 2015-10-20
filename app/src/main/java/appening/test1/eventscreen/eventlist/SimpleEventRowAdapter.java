package appening.test1.eventscreen.eventlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.List;

import appening.test1.R;
import appening.test1.eventscreen.SimpleEventItemAdapter;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Ze on 30/09/2015.
 */
public class SimpleEventRowAdapter extends ArrayAdapter<EventRow>
{
    protected Context context;

    public SimpleEventRowAdapter(Context context)
    {
        super(context, -1, new ArrayList<EventRow>());
        this.context = context;
    }

    public SimpleEventRowAdapter(Context context, List<EventRow> values)
    {
        super(context, -1, values);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_row, parent, false);
        }

        TextView dateTimeView = (TextView) convertView.findViewById(R.id.dateTime);
        TwoWayView rowView = (TwoWayView) convertView.findViewById(R.id.eventRow);
        SimpleEventItemAdapter adapter = new SimpleEventItemAdapter(this.context);

        rowView.setAdapter(adapter);

        EventRow rowData = this.getItem(position);
        assertTrue(rowData != null);

        dateTimeView.setText(rowData.getDate().toString("HH:mm"));
        //if the row already has event data in it, add them to the row adapter
        if (!rowData.isEmpty())
        {
            adapter.addAll(rowData.getEventItems());
        }
        return convertView;
    }
}
