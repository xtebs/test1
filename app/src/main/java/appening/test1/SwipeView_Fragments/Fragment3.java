package appening.test1.SwipeView_Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import appening.test1.PlayGifView;
import appening.test1.R;

/**
 * Created by hugoesteves on 12/07/15.
 */
public class Fragment3 extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment3,container,false);

        TextView text_frag3 = (TextView) v.findViewById(R.id.text_frag3);
        text_frag3.setText("Hello APPeNERs!");


        return v;

    }

}
