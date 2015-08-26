package appening.test1.SwipeView_Fragments;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.hardware.camera2.*;

import java.io.IOException;

/**
 * Surface on which the camera projects it's capture results.
 */
class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder mHolder;
    Camera mCamera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        mCamera = camera;

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        boolean autoFocusOk;

    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            mCamera.setDisplayOrientation(90);
            //Camera.Parameters params
            //mcamera.setDisplayOrientation(90);

            mCamera.setPreviewDisplay(holder);





           //set camera to continually auto-focus
            Camera.Parameters params = mCamera.getParameters();
            //It is better to use defined constraints as opposed to String
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            mCamera.setParameters(params);
            mCamera.autoFocus(cb);
            mCamera.startPreview();
            Log.d("Camera: ", "surfaceCreated ");
            mCamera.autoFocus(cb);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    Camera.AutoFocusCallback cb = new Camera.AutoFocusCallback(){
        public void onAutoFocus(boolean success, Camera camera) {
            // TODO Auto-generated method stub
            //return true;
            Log.d("Camera Focus: ", "focused! ");
        }

    };


    public void surfaceDestroyed(SurfaceHolder holder) {
        // empty. Take care of releasing the Camera preview in your activity.
    }

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (mHolder.getSurface() == null){
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            mCamera.stopPreview();
        } catch (Exception e){
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder);
            //mCamera.startPreview();

            Camera.Parameters params = mCamera.getParameters();
            //It is better to use defined constraints as opposed to String
            params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
            mCamera.setParameters(params);
            mCamera.startPreview();
            Log.d("Camera: ", "surfaceChanged ");
            mCamera.autoFocus(cb);



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}