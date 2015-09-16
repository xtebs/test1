package appening.test1;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.GridView;


public class OldMainActivity extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main_old);

        String event_text_example = "texto bla bla bla bla bla bla bla bla bla bla bla bla";

        int image_ref = R.drawable.camicon100;


        GridView gridview = (GridView) findViewById(R.id.event_grid_xml);
        gridview.setAdapter(new event_item(this, event_text_example, image_ref));


    }


}
