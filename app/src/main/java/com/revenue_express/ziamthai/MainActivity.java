package com.revenue_express.ziamthai;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.revenue_express.ziamthai.adapter.MainPagerAdapter;
import com.revenue_express.ziamthai.adapter.PagerAdapter;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorLayout;
    private BottomBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent intent = new Intent(this, ApplicationMainActivity.class);
//        startActivity(intent);

//        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.three_buttons_activity);
//
//        BottomBar bottomBar = BottomBar.attach(this, savedInstanceState);
//        bottomBar.setItemsFromMenu(R.menu.three_buttons_menu, new OnMenuTabSelectedListener() {
//            @Override
//            public void onMenuItemSelected(int itemId) {
//                switch (itemId) {
//                    case R.id.home_item:
//                        Snackbar.make(coordinatorLayout, "Home Item Selected", Snackbar.LENGTH_LONG).show();
//                        break;
//                    case R.id.point_item:
//                        Snackbar.make(coordinatorLayout, "Point Item Selected", Snackbar.LENGTH_LONG).show();
//                        break;
//                    case R.id.friend_item:
//                        Snackbar.make(coordinatorLayout, "Friend Item Selected", Snackbar.LENGTH_LONG).show();
//                        break;
////                    case R.id.setting_item:
////                        Snackbar.make(coordinatorLayout, "Setting Item Selected", Snackbar.LENGTH_LONG).show();
////                        break;
//                }
//            }
//        });
//
//        // Set the color for the active tab. Ignored on mobile when there are more than three tabs.
//        bottomBar.setActiveTabColor("#C2185B");



        // Use the dark theme. Ignored on mobile when there are more than three tabs.
        //bottomBar.useDarkTheme(true);

        // Use custom text appearance in tab titles.
        //bottomBar.setTextAppearance(R.style.MyTextAppearance);

        // Use custom typeface that's located at the "/src/main/assets" directory. If using with
        // custom text appearance, set the text appearance first.
        //bottomBar.setTypeFace("MyFont.ttf");


        initInstances();

    }


    private void initInstances() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

//        tabLayout.addTab(tabLayout.newTab().setText("Near"));
//        tabLayout.addTab(tabLayout.newTab().setText("Recommend"));
//        tabLayout.addTab(tabLayout.newTab().setText("Review"));
//        tabLayout.addTab(tabLayout.newTab().setText("Deal"));
//        tabLayout.addTab(tabLayout.newTab().setText("Knowledge"));
//        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.photo2));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews").setIcon(R.drawable.photo1));
        tabLayout.addTab(tabLayout.newTab().setText("Deals").setIcon(R.drawable.photo3));
        tabLayout.addTab(tabLayout.newTab().setText("Delivery").setIcon(R.drawable.photo3));
        tabLayout.addTab(tabLayout.newTab().setText("Setting").setIcon(R.drawable.photo4));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final android.support.v4.view.PagerAdapter adapter = new MainPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

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
