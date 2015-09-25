package appening.test1;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by hugoesteves on 20/09/15.
 */
public class GalleryPictureSlideAdapter extends FragmentStatePagerAdapter {

  //  protected static final int[] ICONS = new int[] { R.drawable.abraham_lake_sunset,
  //          R.drawable.bagshaw_battaile_falls, R.drawable.bagshaw_ribbon_of_stone, R.drawable.bagshaw_ruckel_creek_falls };

    public GalleryPictureSlideAdapter(FragmentManager fm_FotoSlide )
    {

        super(fm_FotoSlide);

    }


    @Override
    public Fragment getItem(int position) {


        switch (position){

            case 0: return new GalleryPictureSlide(R.drawable.abraham_lake_sunset);
            case 1: return new GalleryPictureSlide(R.drawable.bagshaw_battaile_falls);
            case 2: return new GalleryPictureSlide(R.drawable.bagshaw_ribbon_of_stone);
            default: break;
        }


        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }



}
