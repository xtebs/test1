package appening.test1.eventscreen.eventlist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.lucasr.twowayview.TwoWayView;

import java.util.TreeMap;

import appening.test1.R;

import static junit.framework.Assert.assertTrue;

/** Created by Ze on 30/09/2015.
 * Nao acabei a implementacao.
 * A ideia por tras desta classe é parecida com o SimpleEventListAdapter, mas também ordenar as EventRows por data,
 * e inserir rows no meio das outras, se a data estiver entre duas rows que já existem.
 * Por enquanto não funciona, ainda não arranjei maneira de criar Views a partir do TreeMap
 * */
@Deprecated
public class EventListAdapter extends ArrayAdapter<EventRow>
{
    protected TreeMap<DateTime, EventRow> values = null;

    /**
     * Similar to super constructor, receive an additional (nullable) TreeMap<DateTime, EventRow> Map with any pre-loaded event rows
     *
     * @param context
     * @param resource
     * @param values
     */
    public EventListAdapter(Context context, int resource, @Nullable TreeMap<DateTime, EventRow> values)
    {
        super(context, resource);
        if (values == null)
        {
            this.values = new TreeMap<>(DateTimeComparator.getInstance());
        } else
        {
            if (!(values.comparator() instanceof DateTimeComparator))
            {
                throw new RuntimeException("Constructor EventRowAdapter(Context, int, TreeMap<DateTime,EventRow>): expected TreeMap with DateTimeComparator. Provided: "
                        + values.comparator().getClass().getName());
            }
            this.values = values;
        }
    }

    //TODO implement notifyDataSetChanged, loading, etc etc
    public void addRow(EventRow row)
    {
        values.put(row.getDate(), row);
        notifyDataSetChanged();
    }

    public View getView(DateTime dateTime, View convertView, ViewGroup parent)
    {
        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.event_row, parent, false);
        }

        TextView dateTimeView = (TextView) convertView.findViewById(R.id.dateTime);
        TwoWayView rowView = (TwoWayView) convertView.findViewById(R.id.eventRow);

        EventRow rowData = values.get(dateTime);
        assertTrue(rowData != null);

        dateTimeView.setText(dateTime.toString("HH"));
        //rowView.

        throw new RuntimeException();
        //return convertView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        throw new UnsupportedOperationException("Not implemented. Use EventRowAdapter.getView(DateTime, View, ViewGroup) instead.");
    }
}
