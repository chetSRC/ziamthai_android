package com.revenue_express.ziamthai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.revenue_express.ziamthai.fragment.DealFragment;
import com.revenue_express.ziamthai.fragment.FriendFragment;
import com.revenue_express.ziamthai.fragment.HomeFragment;
import com.revenue_express.ziamthai.fragment.PointFragment;
import com.revenue_express.ziamthai.fragment.ReviewFragment;
import com.revenue_express.ziamthai.fragment.SettingFragment;


/**
 * Created by chet_cpe on 2/8/2559.
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                HomeFragment tab2 = new HomeFragment();
                return tab2;
            case 1:
                ReviewFragment tab3 = new ReviewFragment();
                return tab3;
            case 2:
                DealFragment tab4 = new DealFragment();
                return tab4;
            case 3:
                SettingFragment tab5 = new SettingFragment();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
