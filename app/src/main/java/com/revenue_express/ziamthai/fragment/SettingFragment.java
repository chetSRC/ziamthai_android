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
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.revenue_express.ziamthai.ApplicationMainActivity;
import com.revenue_express.ziamthai.FriendActivity;
import com.revenue_express.ziamthai.LoginAppActivity;
import com.revenue_express.ziamthai.PointActivity;
import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.RegisterActivity;
import com.revenue_express.ziamthai.SearchActivity;

public class SettingFragment extends Fragment {
    FrameLayout btnLogin,btnRegister,btnPoint,btnFriend;
    public SettingFragment() {
        super();
    }

    public static SettingFragment newInstance() {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_setting, container, false);
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {
        btnLogin = (FrameLayout) rootView.findViewById(R.id.btnLogin);
        btnRegister = (FrameLayout) rootView.findViewById(R.id.btnRegister);
        btnPoint = (FrameLayout) rootView.findViewById(R.id.btnPoint);
        btnFriend = (FrameLayout) rootView.findViewById(R.id.btnFriend);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginAppActivity.class);
//                intent.putExtra("Temp",obj);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
//                intent.putExtra("Temp",obj);
                startActivity(intent);
            }
        });

        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PointActivity.class);
//                intent.putExtra("Temp",obj);
                startActivity(intent);
            }
        });

        btnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FriendActivity.class);
//                intent.putExtra("Temp",obj);
                startActivity(intent);
            }
        });


    }
}
