package com.revenue_express.ziamthai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.revenue_express.ziamthai.dao.DataRecommendDao;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class RestaurantActivity extends FragmentActivity implements OnMapReadyCallback  {
        TextView tvName,tvDetail,tvAddress,tvState,tvCountry,tvPhone,tvMap;
        ImageView imgItem;
        MapView MapView;

        Button btnMap;
//    private GoogleMap mMap;
        String Temp;
    GoogleMap mMap;
//    Marker mMarker;
//    LocationManager lm;
//    double lat, lng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ArrayList<DataRecommendDao> objDao = new ArrayList<>();
        objDao = getIntent().getExtras().getParcelableArrayList("Temp");
//        objDao.get(0).getName();
        tvName = (TextView)findViewById(R.id.tvName);
        tvDetail = (TextView)findViewById(R.id.tvDetail);
        tvAddress = (TextView)findViewById(R.id.tvAddress);
        tvState = (TextView)findViewById(R.id.tvState);
        tvCountry = (TextView)findViewById(R.id.tvCountry);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        tvMap = (TextView)findViewById(R.id.tvMap);
//        btnMap = (Button) findViewById(R.id.btnmap);
        imgItem = (ImageView)findViewById(R.id.imgItem);


//        String string = String.valueOf(objDao.get(0).getPhone());
//        String[] parts = string.split(",");
//        String lat = parts[0];
//        String lng = parts[1];
        String CurrentString = String.valueOf(objDao.get(0).getMap());
        String[] separated = CurrentString.split(",");

        separated[0] = separated[0].trim();
        separated[1] = separated[1].trim();

        String lat = separated[0];
        String lng = separated[1];

        tvName.setText(String.valueOf(objDao.get(0).getName()));
        tvDetail.setText(String.valueOf(objDao.get(0).getDetail()));
        tvAddress.setText("Address : "+String.valueOf(objDao.get(0).getAddress()));
        tvState.setText("State : "+String.valueOf(objDao.get(0).getState()));
        tvCountry.setText("Country : "+String.valueOf(objDao.get(0).getCountry()));
        tvPhone.setText("Tall : "+String.valueOf(objDao.get(0).getPhone()));
        tvMap.setText("Map : "+lat+","+lng);

        Picasso.with(this).load("http://demo.ziamthai.com/admin/"+String.valueOf(objDao.get(0).getImage())).into(imgItem);

//        imgItem.setImageResource(String.valueOf(objDao.get(0).getImage()));
//        Toast.makeText(getApplicationContext(),Temp, Toast.LENGTH_SHORT).show();



//        btnMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(RestaurantActivity.this,MapsActivity.class);
//                startActivity(i);
//            }
//        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        ArrayList<DataRecommendDao> objDao = new ArrayList<>();
        objDao = getIntent().getExtras().getParcelableArrayList("Temp");
        String CurrentString = String.valueOf(objDao.get(0).getMap());
        String[] separated = CurrentString.split(",");

        separated[0] = separated[0].trim();
        separated[1] = separated[1].trim();

        String lat = separated[0];
        String lng = separated[1];

        double valueLat = Double.parseDouble(lat);
        double valueLng = Double.parseDouble(lng);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(valueLat,valueLng);
        mMap.addMarker(new MarkerOptions().position(sydney).title(String.valueOf(objDao.get(0).getName())));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

    }


//    @Override
//    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
//
//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//    }
}
