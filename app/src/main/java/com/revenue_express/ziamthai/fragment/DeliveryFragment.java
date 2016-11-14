package com.revenue_express.ziamthai.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.revenue_express.ziamthai.LoginAppActivity;
import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.RegisterActivity;
import com.revenue_express.ziamthai.SearchActivity;

public class DeliveryFragment extends Fragment {

    public DeliveryFragment() {
        super();
    }

    public static DeliveryFragment newInstance() {
        DeliveryFragment fragment = new DeliveryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_delivery, container, false);
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {

    }
}