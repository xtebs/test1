package appening.test1.SwipeView_Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Camera;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import appening.test1.SwipeView_Fragments.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.Inflater;



import appening.test1.R;

/**
 * Created by hugoesteves on 12/07/15.
 */
public class Fragment2 extends Fragment {


    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private Uri fileUri;


    private Camera mCamera;
    private CameraPreview mPreview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (container == null) {
            return null;
        }

        View cameraView =  inflater.inflate(R.layout.fragment2,container,false);

        // Create an instance of Camera
        mCamera = getCameraInstance();



        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(getActivity(), mCamera);



        FrameLayout preview =  (FrameLayout) cameraView.findViewById(R.id.camera_preview);;// preview RETORNA NULL :( :(
        Log.d("app", "mPreview");
        preview.addView(mPreview);




    return cameraView;

}

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }


/*
    private boolean safeCameraOpenInView(View container) {
        boolean qOpened = false;
        releaseCameraAndPreview();


        qOpened = (mCamera != null);
        mPreview = new CameraPreview(getActivity().getBaseContext(), mCamera);
        FrameLayout preview = (FrameLayout) getActivity().findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        return qOpened;
    }

    */

/*
    private void releaseCameraAndPreview() {
        mPreview.setCamera(null);
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }
*/

    /*

     /*
    public void setCamera(Camera camera) {
        if (mCamera == camera) { return; }

        stopPreviewAndFreeCamera();

        mCamera = camera;

        if (mCamera != null) {
            List<Camera.Size> localSizes = mCamera.getParameters().getSupportedPreviewSizes();
            mSupportedPreviewSizes = localSizes;
            requestLayout();

            try {
                mCamera.setPreviewDisplay(mHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Important: Call startPreview() to start updating the preview
            // surface. Preview must be started before you can take a picture.
            mCamera.startPreview();
        }
    }
*/

}






