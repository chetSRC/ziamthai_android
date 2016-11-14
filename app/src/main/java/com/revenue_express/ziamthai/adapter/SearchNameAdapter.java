package com.revenue_express.ziamthai.adapter;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.revenue_express.ziamthai.dao.SearchNameDao;
import com.revenue_express.ziamthai.fragment.SearchNameFragment;
import com.revenue_express.ziamthai.manager.SearchJsonParse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChetPC on 11/9/2016.
 */
public class SearchNameAdapter extends ArrayAdapter<String>{

    protected static final String TAG ="SearchNameAdapter";
    private List<String> searchname,searchId;

        public SearchNameAdapter(Activity context, String nameFilter) {
        super(context,android.R.layout.simple_dropdown_item_1line);
            searchname = new ArrayList<String>();
    }

    @Override
    public int getCount() {
        return searchname.size();
    }

    @Override
    public String getItem(int index) {
        return searchname.get(index);
    }

    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                SearchJsonParse jp=new SearchJsonParse();
                if (constraint != null) {
                    // A class that queries a web API, parses the data and
                    // returns an ArrayList<GoEuroGetSet>
                    List<SearchNameDao> new_searchname =jp.getParseJsonWCF(constraint.toString());
                    searchname.clear();
                    for (int i=0;i<new_searchname.size();i++) {
                        searchname.add(new_searchname.get(i).getBssh_title()+","+new_searchname.get(i).getBssh_id());
                    }

                    // Now assign the values and count to the FilterResults
                    // object
                    filterResults.values = searchname;
                    filterResults.count = searchname.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence contraint,
                                          FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };
        return myFilter;
    }

}
