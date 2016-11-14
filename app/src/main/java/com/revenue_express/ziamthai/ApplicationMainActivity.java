package com.revenue_express.ziamthai;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.inthecheesefactory.thecheeselibrary.manager.bus.MainBus;
import com.revenue_express.ziamthai.adapter.PagerAdapter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;



/**
 * Created by chet_cpe on 5/8/2559.
 */
public class ApplicationMainActivity extends AppCompatActivity {
    LinearLayout btnHome, btnPoint, btnFriend, btnSetting;
    Spinner spnState;
    ImageView ImgSearch;
    ArrayList<String> arrayList = new ArrayList<>();
    EditText edtShearch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_main);

        //final String TAG = "Fragment1";

        android.support.v7.widget.Toolbar toolbar;
        ActionBarDrawerToggle actionBarDrawerToggle;
        DrawerLayout drawerLayout;

        initInstances();
        getIntenValue();
        setInitView();


        ImgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);

            }
        });

    }



    private void setInitView() {
       ImgSearch = (ImageView)findViewById(R.id.img_search);

    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*if(actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        switch (item.getItemId()){
            case R.id.action_settings:
                return true;

        }
        return super.onOptionsItemSelected(item);
        */
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainBus.getInstance().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainBus.getInstance().unregister(this);
    }

    private void initInstances() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.photo2));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews").setIcon(R.drawable.photo1));
        tabLayout.addTab(tabLayout.newTab().setText("Deals").setIcon(R.drawable.photo3));
        tabLayout.addTab(tabLayout.newTab().setText("Delivery").setIcon(R.drawable.photo3));
        tabLayout.addTab(tabLayout.newTab().setText("Setting").setIcon(R.drawable.photo4));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final android.support.v4.view.PagerAdapter adapter = new PagerAdapter
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

    private void getIntenValue() {
        // get Intent
        Intent inboundIntent = getIntent();
        // set get data Intent to variable

    }

    public static String printKeyHash(Activity context) {
        PackageInfo packageInfo;
        String key = null;
        try {
            //getting application package name, as defined in manifest
            String packageName = context.getApplicationContext().getPackageName();

            //Retriving package info
            packageInfo = context.getPackageManager().getPackageInfo(packageName,
                    PackageManager.GET_SIGNATURES);

            Log.e("Package Name=", context.getApplicationContext().getPackageName());

            for (Signature signature : packageInfo.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                key = new String(Base64.encode(md.digest(), 0));

                // String key = new String(Base64.encodeBytes(md.digest()));
                Log.e("Key Hash=", key);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("Name not found", e1.toString());
        }
        catch (NoSuchAlgorithmException e) {
            Log.e("No such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("Exception", e.toString());
        }

        return key;
    }

}
