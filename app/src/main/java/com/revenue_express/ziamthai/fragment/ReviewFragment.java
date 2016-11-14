package com.revenue_express.ziamthai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.SearchActivity;


/**
 * Created by chet_cpe on 2/8/2559.
 */

public class ReviewFragment extends Fragment {
    public ReviewFragment() {
        super();
    }

    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_review, container, false);
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {

    }
}