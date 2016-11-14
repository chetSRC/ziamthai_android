package com.revenue_express.ziamthai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.revenue_express.ziamthai.fragment.DealFragment;
import com.revenue_express.ziamthai.fragment.DeliveryFragment;
import com.revenue_express.ziamthai.fragment.KnowledgeFragment;
import com.revenue_express.ziamthai.fragment.RecommendFragment;
import com.revenue_express.ziamthai.fragment.ReviewFragment;
import com.revenue_express.ziamthai.fragment.SettingFragment;


/**
 * Created by chet_cpe on 2/8/2559.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                RecommendFragment tab1 = new RecommendFragment();
                return tab1;
            case 1:
                ReviewFragment tab2 = new ReviewFragment();
                return tab2;
            case 2:
                DealFragment tab3 = new DealFragment();
                return tab3;
            case 3:
                DeliveryFragment tab4 = new DeliveryFragment();
                return tab4;
            case 4:
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
