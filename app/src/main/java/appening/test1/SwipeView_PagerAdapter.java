package appening.test1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import appening.test1.SwipeView_Fragments.Fragment1;
import appening.test1.SwipeView_Fragments.Fragment2;
import appening.test1.SwipeView_Fragments.Fragment3;
import appening.test1.infiniscroll.InfiniteScrollActivity;

/**
 * Created by hugoesteves on 12/07/15.
 */
public class SwipeView_PagerAdapter extends FragmentPagerAdapter{


    public SwipeView_PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {


        switch (position){

            case 0: return new Fragment1();
            case 1: return new Fragment2();
            case 2: return new Fragment3();
            default: break;
        }


return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
