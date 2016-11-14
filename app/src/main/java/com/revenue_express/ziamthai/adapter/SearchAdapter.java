package com.revenue_express.ziamthai.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.dao.RecommendItemDao;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;
import com.revenue_express.ziamthai.fragment.DealFragment;
import com.revenue_express.ziamthai.fragment.KnowledgeFragment;
import com.revenue_express.ziamthai.fragment.NearByFragment;
import com.revenue_express.ziamthai.fragment.RecommendFragment;
import com.revenue_express.ziamthai.fragment.ReviewFragment;
import com.revenue_express.ziamthai.fragment.SearchNameFragment;
import com.revenue_express.ziamthai.fragment.SearchStateFragment;
import com.revenue_express.ziamthai.manager.DealListManager;
import com.revenue_express.ziamthai.view.DealListItem;


/**
 * Created by ChetPC on 10/28/2016.
 */
public class SearchAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SearchAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SearchNameFragment tab2 = new SearchNameFragment();
                return tab2;
            case 1:
                SearchStateFragment tab3 = new SearchStateFragment();
                return tab3;
            case 2:
                NearByFragment tab4 = new NearByFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
