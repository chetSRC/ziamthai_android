package com.revenue_express.ziamthai;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.revenue_express.ziamthai.dao.DataRecommendDao;
import com.revenue_express.ziamthai.dao.SearchName2Dao;
import com.revenue_express.ziamthai.dao.SearchNameDao;
import com.revenue_express.ziamthai.manager.SearchNameJsonParse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RestaurantSearchActivity extends AppCompatActivity {
    @SuppressLint("NewApi")
    TextView tvName,tvDetail,tvAddress,tvState,tvCountry,tvPhone,tvMap;
    ImageView imgItem;
    GoogleMap mMap;
    String temp;
    String name;
//    url = http://demo.ziamthai.com/index.php/shopInfo/searchShopInfoById/35
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_search);

        tvName = (TextView)findViewById(R.id.tvName);
        tvDetail = (TextView)findViewById(R.id.tvDetail);
        tvAddress = (TextView)findViewById(R.id.tvAddress);
        tvState = (TextView)findViewById(R.id.tvState);
        tvCountry = (TextView)findViewById(R.id.tvCountry);
        tvPhone = (TextView)findViewById(R.id.tvPhone);
        tvMap = (TextView)findViewById(R.id.tvMap);
        imgItem = (ImageView)findViewById(R.id.imgItem);



//        ArrayList<SearchName2Dao> obj = new ArrayList<SearchName2Dao>();
//        SearchNameJsonParse jParser = new SearchNameJsonParse();

        temp = getIntent().getExtras().getString("temp");
        String CurrentString = String.valueOf(temp);
        String[] separated = CurrentString.split(",");

        separated[0] = separated[0].trim();
        separated[1] = separated[1].trim();

        String name = separated[0];
        String id = separated[1];
        final String URL = "http://demo.ziamthai.com/index.php/shopInfo/searchShopInfoById/"+id;



        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {
                OkHttpClient okHttpClient = new OkHttpClient();

                Request.Builder builder = new Request.Builder();
                Request request = builder.url(URL).build();

                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if (response.isSuccessful()) {
                        return response.body().string();
                    } else {
                        return "Not Success - code : " + response.code();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return "Error - " + e.getMessage();
                }
            }

            @Override
            protected void onPostExecute(String string) {
                super.onPostExecute(string);
                try {
                    JSONObject jsnobject = new JSONObject(string);

                    String bssh_title = String.valueOf(jsnobject.getString("bssh_title"));
                    Toast.makeText(getApplicationContext(),bssh_title,Toast.LENGTH_LONG).show();
                    tvName.setText(bssh_title);
//                    Log.e("onPost",bssh_title);

                    String bssh_detail = String.valueOf(jsnobject.getString("bssh_detail"));
                    tvDetail.setText(bssh_detail);

                    String bssh_address = String.valueOf(jsnobject.getString("bssh_address"));
                    tvAddress.setText("Address : "+bssh_address);

                    String bssh_loc1 = String.valueOf(jsnobject.getString("bssh_loc1"));
                    tvCountry.setText("Country : "+bssh_loc1);

                    String bssh_loc2 = String.valueOf(jsnobject.getString("bssh_loc2"));
                    tvState.setText("State : "+bssh_loc2);

                    String bssh_phone = String.valueOf(jsnobject.getString("bssh_phone"));
                    tvPhone.setText("Tall : "+bssh_phone);

                    String bssh_maps = String.valueOf(jsnobject.getString("bssh_maps"));
                    tvMap.setText("Map : "+bssh_maps);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }.execute();


    }


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


}
