package com.revenue_express.ziamthai.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.adapter.RecommendAdapter;
import com.revenue_express.ziamthai.adapter.SearchAdapter;
import com.revenue_express.ziamthai.adapter.SearchNameAdapter;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;

import java.util.ArrayList;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SearchNameFragment extends Fragment {

    AutoCompleteTextView autoComplete;
    RecommendAdapter listAdepter;
    RecommendListItemDao dao;
    ArrayAdapter<String> adapter;


    public SearchNameFragment() {
        super();
    }

    public static SearchNameFragment newInstance() {
        SearchNameFragment fragment = new SearchNameFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search_name, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        autoComplete = (AutoCompleteTextView)rootView.findViewById(R.id.atcRestaurant);
//        autoComplete.setAdapter(new  SearchAdapter(getActivity(),autoComplete.getText().toString()));
//        autoComplete.setAdapter(new SearchNameAdapter(this,autoComplete.getText().toString()));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
