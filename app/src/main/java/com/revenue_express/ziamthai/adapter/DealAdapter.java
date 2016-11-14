package com.revenue_express.ziamthai.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.dao.RecommendItemDao;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;
import com.revenue_express.ziamthai.manager.DealListManager;
import com.revenue_express.ziamthai.manager.RecommendListManager;
import com.revenue_express.ziamthai.view.DealListItem;
import com.revenue_express.ziamthai.view.RecommendListItem;


/**
 * Created by ChetPC on 10/28/2016.
 */
public class DealAdapter extends BaseAdapter {
    RecommendListItemDao dao;
    int lastPosition = -1;

    public void setDao(RecommendListItemDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if (DealListManager.getInstance().getDao() == null)
            return 0;
        if (DealListManager.getInstance().getDao().getData() == null)
            return 0;
        return DealListManager.getInstance().getDao().getData().size();
    }

    @Override
    public Object getItem(int position) {

        return DealListManager.getInstance().getDao().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DealListItem item;
        if (convertView != null)
            item = (DealListItem) convertView;
        else
            item = new DealListItem(parent.getContext());
        RecommendItemDao dao = (RecommendItemDao) getItem(position);
        String name = dao.getName();
        String state = dao.getState();
        String imageurl = "http://demo.ziamthai.com/admin/"+dao.getImage();
        item.setTvName(dao.getName());
        item.setTvState(dao.getState());
        item.setImgItem("http://demo.ziamthai.com/admin/"+dao.getImage());

        if (position > lastPosition){
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(),
                    R.anim.up_from_bottom);
            item.startAnimation(anim);
            lastPosition = position;
        }

        return item;
    }


}
