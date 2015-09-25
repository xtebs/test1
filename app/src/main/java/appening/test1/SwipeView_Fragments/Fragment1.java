package appening.test1.SwipeView_Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import appening.test1.GalleryPictureSlideAdapter;
import appening.test1.R;

import appening.test1.event_item;


/**
 * Created by hugoesteves on 12/07/15.
 */
public class Fragment1 extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View gallery = inflater.inflate(R.layout.fragment1,container,false);

        //setContentView(R.layout.activity_main_old);



        String event_text_example = "text";// not used right now

        int image_ref = R.drawable.camicon100; // not used right now



        GridView gridview = (GridView) gallery.findViewById(R.id.event_grid_xml);
        gridview.setAdapter(new event_item(getActivity(), event_text_example, image_ref));

        return gallery;
    }



    }




