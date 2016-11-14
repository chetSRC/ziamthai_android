package com.revenue_express.ziamthai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.revenue_express.ziamthai.fragment.DealFragment;
import com.revenue_express.ziamthai.fragment.KnowledgeFragment;
import com.revenue_express.ziamthai.fragment.RecommendFragment;
import com.revenue_express.ziamthai.fragment.ReviewFragment;


/**
 * Created by chet_cpe on 2/8/2559.
 */
public class TabAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public TabAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                RecommendFragment tab2 = new RecommendFragment();
                return tab2;
            case 1:
                ReviewFragment tab3 = new ReviewFragment();
                return tab3;
            case 2:
                DealFragment tab4 = new DealFragment();
                return tab4;
            case 3:
                KnowledgeFragment tab5 = new KnowledgeFragment();
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
