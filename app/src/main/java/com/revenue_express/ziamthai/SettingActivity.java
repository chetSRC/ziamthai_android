package com.revenue_express.ziamthai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SettingActivity extends AppCompatActivity {
//    TextView TVSetting,TVSetting1;
    Button btnLogin,btnRegister;
    LinearLayout btnHome, btnPoint, btnFriend, btnSetting;
    ImageView ImgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setInitView();
        BottonBarManage();

//        String Setting;
//        String Setting1 = "Setting1";
//        Setting = getIntent().getStringExtra("tempSetting");
//
//        TVSetting = (TextView) findViewById(R.id.tvSetting);
//        TVSetting.setText(Setting);
//
//        TVSetting1 = (TextView) findViewById(R.id.tvSetting1);
//        TVSetting1.setText(Setting1);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, LoginAppActivity.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        ImgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent);

            }
        });
    }

    private void setInitView(){
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnHome = (LinearLayout) findViewById(R.id.btnHome);
        btnPoint = (LinearLayout)findViewById(R.id.btnPoint);
        btnFriend = (LinearLayout)findViewById(R.id.btnFriend);
        btnSetting = (LinearLayout)findViewById(R.id.btnSetting);
        ImgSearch = (ImageView)findViewById(R.id.img_search);
    }

    private void BottonBarManage() {
        // setbottombar
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ApplicationMainActivity.class);

                String Home = "Home";
                intent.putExtra("tempHome",Home);


                startActivity(intent);
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PointActivity.class);

                String Point = "Point";
                intent.putExtra("tempPoint",Point);


                startActivity(intent);
            }
        });
        btnFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FriendActivity.class);

                String Friend = "Friend";
                intent.putExtra("tempFriend",Friend);


                startActivity(intent);
            }
        });
        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SettingActivity.class);

                String Setting = "Setting";
                intent.putExtra("tempSetting",Setting);


                startActivity(intent);
            }
        });
    }
}
