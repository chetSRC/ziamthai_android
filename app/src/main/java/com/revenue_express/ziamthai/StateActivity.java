package com.revenue_express.ziamthai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StateActivity extends AppCompatActivity {
    TextView tvState;
    ImageView imgState;
    String flagstate;
    LinearLayout btnHome, btnPoint, btnFriend, btnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        setInitView();
        BottonBarManage();

        FlagManage();

    }

    private void FlagManage() {
        tvState = (TextView) findViewById(R.id.tvStete);
        String state = getIntent().getStringExtra("NameState");
        tvState.setText(state);
/*
        imgState = (ImageView)findViewById(R.id.imgState);

        if (state == "Delaware"){
            flagstate = "delaware";
            imgState.setImageResource(R.drawable.delaware);
        }else if (state == "Pennsylvania"){
            flagstate = "pennsylvania";
            imgState.setImageResource(R.drawable.pennsylvania);
        }else if (state == "New Jersey"){
            flagstate = "new_jersey";
            imgState.setImageResource(R.drawable.new_jersey);
        }else if (state == "Georgia"){
            flagstate = "georgia";
            imgState.setImageResource(R.drawable.georgia);
        }else if (state == "Connecticut"){
            flagstate = "connecticut";
            imgState.setImageResource(R.drawable.connecticut);
        }else if (state == "Massachusetts"){
            flagstate = "massachusetts";
            imgState.setImageResource(R.drawable.massachusetts);
        }else if (state == "Maryland"){
            flagstate = "maryland";
            imgState.setImageResource(R.drawable.marland);
        }else if (state == "South Carolina"){
            flagstate = "south_carolina";
            imgState.setImageResource(R.drawable.south_carolina);
        }else if (state == "New Hampshire"){
            flagstate = "new_hampshire";
            imgState.setImageResource(R.drawable.new_hampshire);
        }else if (state == "Virginia"){
            flagstate = "virginia";
            imgState.setImageResource(R.drawable.virginia);
        }else if (state == "New York"){
            flagstate = "new_york";
            imgState.setImageResource(R.drawable.new_york);
        }else if (state == "North Carolina"){
            flagstate = "north_carolina";
            imgState.setImageResource(R.drawable.north_carolina);
        }else if (state == "Rhode Island"){
            flagstate = "rhode_island";
            imgState.setImageResource(R.drawable.rhode_island);
        }else if (state == "Vermont"){
            flagstate = "vermont";
            imgState.setImageResource(R.drawable.vermont);
        }else if (state == "Kentucky"){
            flagstate = "kentucky";
            imgState.setImageResource(R.drawable.kentucky);
        }else if (state == "Tennessee"){
            flagstate = "tennessee";
            imgState.setImageResource(R.drawable.tennessee);
        }else if (state == "Ohio"){
            flagstate = "ohio";
            imgState.setImageResource(R.drawable.ohio);
        }else if (state == "Louisiana"){
            flagstate = "louisiana";
            imgState.setImageResource(R.drawable.louisiana);
        }else if (state == "Indiana"){
            flagstate = "indiana";
            imgState.setImageResource(R.drawable.indiana);
        }else if (state == "Mississippi"){
            flagstate = "mississippi";
            imgState.setImageResource(R.drawable.mississippi);
        }else if (state == "Illinois"){
            flagstate = "illinois";
            imgState.setImageResource(R.drawable.illinois);
        }else if (state == "Alabama"){
            flagstate = "alabama";
            imgState.setImageResource(R.drawable.alabama);
        }else if (state == "Maine"){
            flagstate = "maine";
            imgState.setImageResource(R.drawable.maine);
        }else if (state == "Missouri"){
            flagstate = "missouri";
            imgState.setImageResource(R.drawable.mississippi);
        }else if (state == "Arkansas"){
            flagstate = "arkansas";
            imgState.setImageResource(R.drawable.arkansas);
        }else if (state == "Michigan"){
            flagstate = "michigan";
            imgState.setImageResource(R.drawable.michigan);
        }else if (state == "Florida"){
            flagstate = "florida";
            imgState.setImageResource(R.drawable.florida);
        }else if (state == "Texas"){
            flagstate = "texas";
            imgState.setImageResource(R.drawable.texas);
        }else if (state == "Iowa"){
            flagstate = "iowa";
            imgState.setImageResource(R.drawable.iowa);
        }else if (state == "Wisconsin"){
            flagstate = "wisconsin";
            imgState.setImageResource(R.drawable.wisconsin);
        }else if (state == "California"){
            flagstate = "california";
            imgState.setImageResource(R.drawable.california);
        }else if (state == "Minnesota"){
            flagstate = "minnesota";
            imgState.setImageResource(R.drawable.minnesota);
        }else if (state == "Oregon"){
            flagstate = "oregon";
            imgState.setImageResource(R.drawable.oregon);
        }else if (state == "Kansas"){
            flagstate = "kansas";
            imgState.setImageResource(R.drawable.kansas);
        }else if (state == "West Virginia"){
            flagstate = "west_virginia";
            imgState.setImageResource(R.drawable.west_virginia);
        }else if (state == "Nevada"){
            flagstate = "nevada";
            imgState.setImageResource(R.drawable.nevada);
        }else if (state == "Nebraska"){
            flagstate = "nebraska";
            imgState.setImageResource(R.drawable.nebraska);
        }else if (state == "Colorado"){
            flagstate = "colorado";
            imgState.setImageResource(R.drawable.colorado);
        }else if (state == "North Dakota"){
            flagstate = "north_dakota";
            imgState.setImageResource(R.drawable.north_dakota);
        }else if (state == "South Dakota"){
            flagstate = "south_dakota";
            imgState.setImageResource(R.drawable.south_dakota);
        }else if (state == "Montana"){
            flagstate = "Montana";
            imgState.setImageResource(R.drawable.montana);
        }else if (state == "Washington"){
            flagstate = "washington";
            imgState.setImageResource(R.drawable.washington);
        }else if (state == "Idaho"){
            flagstate = "idaho";
            imgState.setImageResource(R.drawable.idaho);
        }else if (state == "Wyoming"){
            flagstate = "wyoming";
            imgState.setImageResource(R.drawable.wyoming);
        }else if (state == "Utah"){
            flagstate = "utah";
            imgState.setImageResource(R.drawable.utah);
        }else if (state == "Oklahoma"){
            flagstate = "oklahoma";
            imgState.setImageResource(R.drawable.oklahoma);
        }else if (state == "New Mexico"){
            flagstate = "new_mexico";
            imgState.setImageResource(R.drawable.new_mexico);
        }else if (state == "Arizona"){
            flagstate = "arizona";
            imgState.setImageResource(R.drawable.arizona);
        }else if (state == "Alaska"){
            flagstate = "alaska";
            imgState.setImageResource(R.drawable.alaska);
        }else if (state == "Hawaii"){
            flagstate = "hawaii";
            imgState.setImageResource(R.drawable.hawaii);
        }else {
            flagstate = "flag";
            imgState.setImageResource(R.drawable.flag);
        }
        */
    }

    private void setInitView(){


        btnHome = (LinearLayout) findViewById(R.id.btnHome);
        btnPoint = (LinearLayout)findViewById(R.id.btnPoint);
        btnFriend = (LinearLayout)findViewById(R.id.btnFriend);
        btnSetting = (LinearLayout)findViewById(R.id.btnSetting) ;
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
