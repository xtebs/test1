package appening.test1.infiniscroll;

import android.graphics.drawable.Drawable;

/**
 * Created by Ze on 02/07/2015.
 */
public class EventInfo
{

    public EventInfo(Drawable image, String title, String description)
    {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public Drawable getImage()
    {
        return image;
    }

    public void setImage(Drawable image)
    {
        this.image = image;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public Drawable image;
    public String title;
    public String description;


}
