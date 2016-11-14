package com.revenue_express.ziamthai.manager;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DealListManager {

    private static DealListManager instance;

    public static DealListManager getInstance() {
        if (instance == null)
            instance = new DealListManager();
        return instance;
    }

    private Context mContext;
    private RecommendListItemDao dao;

    private DealListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public RecommendListItemDao getDao() {
        return dao;
    }

    public void setDao(RecommendListItemDao dao) {this.dao = dao;}
}
