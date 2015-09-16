package appening.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by hugoesteves on 21/06/15.
 */
public class event_item extends BaseAdapter{

    Context context;
    String event_text_exemple;
    int image_ref;

   public event_item(Context context, String event_text_exemple, int image_ref){

        this.context = context;
        this.event_text_exemple=event_text_exemple;
        //this.image_ref = image_ref;

    }




    @Override
    public int getCount() {
        return 60;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


       LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
convertView = inflater.inflate(R.layout.event_item,parent,false);

        TextView event_text_exemple_view = (TextView)convertView.findViewById(R.id.event_text_exemple_xml);
        ImageView image_ref_view = (ImageView)convertView.findViewById(R.id.image_ref_xml);


        event_text_exemple_view.setText( event_text_exemple.toString());
        image_ref_view.setImageResource(image_ref);

return convertView;
    }



}
