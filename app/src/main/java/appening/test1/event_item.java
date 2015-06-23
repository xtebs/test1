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
        this.image_ref = image_ref;

    }




    @Override
    public int getCount() {
        return 10;
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

    /*

     LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.each_event_on_list, parent,false);


            TextView title = (TextView)convertView.findViewById(R.id.title);
            TextView value = (TextView)convertView.findViewById(R.id.value);
            TextView date = (TextView)convertView.findViewById(R.id.date);

            ImageView eventpic = (ImageView)convertView.findViewById(R.id.eventimage);

            title.setText( lista_title.get(position).toString());
            value.setText(lista_text.get(position).toString());
            date.setText(lista_date.get(position).toString());
            eventpic.setImageResource(lista_image.get(position));


     */


        /* LayoutInflater inflater =
    convertView = inflater.inflate(R.layout.event_item, parent,false);
*/


}
