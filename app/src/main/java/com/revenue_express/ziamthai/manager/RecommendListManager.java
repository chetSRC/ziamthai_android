package com.revenue_express.ziamthai.manager;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class RecommendListManager {

    private static RecommendListManager instance;

    public static RecommendListManager getInstance() {
        if (instance == null)
            instance = new RecommendListManager();
        return instance;
    }

    private Context mContext;
    private RecommendListItemDao dao;

    private RecommendListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public RecommendListItemDao getDao() {
        return dao;
    }

    public void setDao(RecommendListItemDao dao) {
        this.dao = dao;
    }
}
