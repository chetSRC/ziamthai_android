package com.revenue_express.ziamthai;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.revenue_express.ziamthai.adapter.RecommendAdapter;
import com.revenue_express.ziamthai.adapter.SearchAdapter;
import com.revenue_express.ziamthai.adapter.SearchNameAdapter;
import com.revenue_express.ziamthai.adapter.TabAdapter;
import com.revenue_express.ziamthai.dao.DataRecommendDao;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;
import com.revenue_express.ziamthai.dao.SearchNameDao;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    ImageView ImgHome;
    LinearLayout btnHome, btnPoint, btnFriend, btnSetting;
    AutoCompleteTextView autoComplete;
    Button btnSearch;
    SearchNameDao dao;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initInstances();
        BottonBarManage();

        autoComplete.setAdapter(new SearchNameAdapter(this,autoComplete.getText().toString()));
    }


// ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();


    private void initInstances() {

        ImgHome = (ImageView) findViewById(R.id.img_home);

        btnHome = (LinearLayout) findViewById(R.id.btnHome);
        btnPoint = (LinearLayout) findViewById(R.id.btnPoint);
        btnFriend = (LinearLayout) findViewById(R.id.btnFriend);
        btnSetting = (LinearLayout) findViewById(R.id.btnSetting);
        btnSearch = (Button)findViewById(R.id.btnSearch);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        autoComplete = (AutoCompleteTextView)findViewById(R.id.atcRestaurant);
//        final TabLayout tabLayout1 = (TabLayout) findViewById(R.id.tab_layout1);
//        final ViewPager viewPager1 = (ViewPager) findViewById(R.id.pager1);

//        tabLayout.addTab(tabLayout.newTab().setText("Near"));
//        tabLayout1.addTab(tabLayout1.newTab().setText("Namm"));
//        tabLayout1.addTab(tabLayout1.newTab().setText("State"));
//        tabLayout1.addTab(tabLayout1.newTab().setText("Near By"));
//        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        final PagerAdapter adapter = new SearchAdapter
//                (getSupportFragmentManager(), tabLayout1.getTabCount());
//        viewPager1.setAdapter(adapter);
//        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
//        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager1.setCurrentItem(tab.getPosition());
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


        ImgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ApplicationMainActivity.class);
                startActivity(intent);
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RestaurantSearchActivity.class);
                String temp = autoComplete.getText().toString();


                intent.putExtra("temp", temp);
                startActivity(intent);
            }
        });

//        autoComplete.setClickable(true);
//        autoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String a = dao.getBssh_title();
////                Toast.makeText(getActivity(), a, Toast.LENGTH_LONG).show();
//                ArrayList<SearchNameDao> obj = new ArrayList<SearchNameDao>();
//
//                SearchNameDao temp = new SearchNameDao();
//                temp.setBssh_id(String.valueOf(dao.getBssh_id()));
//                temp.setBssh_title(String.valueOf(dao.getBssh_title()));
//                temp.setBssh_detail(String.valueOf(dao.getBssh_detail()));
//                temp.setBssh_address(String.valueOf(dao.getBssh_address()));
//                temp.setBssh_maps(String.valueOf(dao.getBssh_maps()));
//                temp.setBssh_loc1(String.valueOf(dao.getBssh_loc1()));
//                temp.setBssh_loc2(String.valueOf(dao.getBssh_loc2()));
//                temp.setBssh_loc3(String.valueOf(dao.getBssh_loc3()));
//                temp.setBssh_phone(String.valueOf(dao.getBssh_phone()));
//                temp.setBssh_website(String.valueOf(dao.getBssh_website()));
//                temp.setBssh_email(String.valueOf(dao.getBssh_email()));
//                temp.setBssh_imghead(String.valueOf(dao.getBssh_imghead()));
//                obj.add(temp);
//
//                Intent intent = new Intent(getApplicationContext(), RestaurantSearchActivity.class);
//                intent.putExtra("Temp",obj);
//                startActivity(intent);
//            }
//        });
    }

    private void BottonBarManage() {
        // setbottombar
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ApplicationMainActivity.class);

                String Home = "Home";
                intent.putExtra("tempHome", Home);


                startActivity(intent);
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PointActivity.class);

                String Point = "Point";
                intent.putExtra("tempPoint", Point);


                startActivity(intent);
            }
        });
        btnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FriendActivity.class);

                String Friend = "Friend";
                intent.putExtra("tempFriend", Friend);


                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);

                String Setting = "Setting";
                intent.putExtra("tempSetting", Setting);


                startActivity(intent);
            }
        });
    }
}
