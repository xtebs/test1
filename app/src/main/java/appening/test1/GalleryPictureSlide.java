package appening.test1;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hugoesteves on 23/09/15.
 */
public class GalleryPictureSlide extends Fragment {

    Integer picture;
    public GalleryPictureSlide(Integer picture) {
        this.picture = picture;

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View gallerySlide = inflater.inflate(R.layout.picture_slide, container, false);


//CORRECTION TO FRAGMENT 1 SLIDE VIEWPAGER - NOT HAPPENING
        GalleryPictureSlideAdapter fotoSlide = new GalleryPictureSlideAdapter(getFragmentManager());
        ViewPager image_slide = (ViewPager)getActivity().findViewById(R.id.slide_each_image);

        image_slide.setBackgroundResource(picture);

        image_slide.setAdapter(fotoSlide);

        return gallerySlide;

    }
}