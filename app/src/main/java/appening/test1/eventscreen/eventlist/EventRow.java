package appening.test1.eventscreen.eventlist;

import android.support.annotation.Nullable;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import appening.test1.eventscreen.SelfLoadingGalleryItem;

/**
 * Created by Ze on 28/09/2015.
 */
public class EventRow
{
    private DateTime date;
    private List<SelfLoadingGalleryItem> eventItems;

    public EventRow(DateTime dateTime, @Nullable List<SelfLoadingGalleryItem> items)
    {
        this.date = dateTime;
        if (items == null)
        {
            eventItems = new ArrayList<>();
        } else
        {
            this.eventItems = items;
        }
    }

    public void addItem(SelfLoadingGalleryItem event) {
        eventItems.add(event);
    }

    public void addAll(Collection<SelfLoadingGalleryItem> events) {
        eventItems.addAll(events);
    }

    public DateTime getDate()
    {
        return date;
    }

    public void setDate(DateTime date)
    {
        this.date = date;
    }

    public List<SelfLoadingGalleryItem> getEventItems()
    {
        return eventItems;
    }

    public void setEventItems(List<SelfLoadingGalleryItem> eventItems)
    {
        this.eventItems = eventItems;
    }

    public int size() {
        return eventItems.size();
    }

    public boolean isEmpty() {
        return eventItems.isEmpty();
    }
}
