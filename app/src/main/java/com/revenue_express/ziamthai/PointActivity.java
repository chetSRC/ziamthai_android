package com.revenue_express.ziamthai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {
    TextView TVPoint,TVPoint1;

//    ImageView ImgSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        setInitView();
        BottonBarManage();

        String Point;
        String Point1 = "Point1";
        Point = getIntent().getStringExtra("tempPoint");

        TVPoint = (TextView) findViewById(R.id.tvPoint);
        TVPoint.setText(Point);

        TVPoint1 = (TextView) findViewById(R.id.tvPoint1);
        TVPoint1.setText(Point1);

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
