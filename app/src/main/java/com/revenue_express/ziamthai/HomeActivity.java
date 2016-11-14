package com.revenue_express.ziamthai;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.revenue_express.ziamthai.adapter.TabAdapter;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initInstances();
    }
    private void initInstances() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final TabLayout tabLayout1 = (TabLayout) findViewById(R.id.tab_layout);
        final ViewPager viewPager1 = (ViewPager) findViewById(R.id.pager);

//        tabLayout.addTab(tabLayout.newTab().setText("Near"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Recommend"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Review"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Deal"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Knowledge"));
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        final android.support.v4.view.PagerAdapter adapter = new TabAdapter
                (getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(adapter);
        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));
        tabLayout1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
