package com.revenue_express.ziamthai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FriendActivity extends AppCompatActivity {
    TextView TVFriend,TVFriend1;
//    ImageView ImgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        setInitView();
        BottonBarManage();

        String Friend;
        String Friend1 = "Friend1";
        Friend = getIntent().getStringExtra("tempFriend");

        TVFriend = (TextView) findViewById(R.id.tvFriend);
        TVFriend.setText(Friend);

        TVFriend1 = (TextView) findViewById(R.id.tvFriend1);
        TVFriend1.setText(Friend1);

//        ImgSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
//                startActivity(intent);
//
//            }
//        });
    }

    private void setInitView(){
    }

    private void BottonBarManage() {

    }
}
