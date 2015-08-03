package appening.test1.SwipeView_Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import appening.test1.SwipeView_Fragments.*;
import java.io.File;
import java.io.IOException;
import java.util.zip.Inflater;



import appening.test1.R;

/**
 * Created by hugoesteves on 12/07/15.
 */
public class Fragment2 extends Fragment {

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {




        return inflater.inflate(R.layout.fragment2,container,false);

    }



}
