package com.revenue_express.ziamthai.manager;

import com.revenue_express.ziamthai.dao.SearchNameDao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by ChetPC on 11/9/2016.
 */
public class SearchJsonParse {
    double current_latitude,current_longitude;
    public SearchJsonParse(){}
    public SearchJsonParse(double current_latitude,double current_longitude){
        this.current_latitude=current_latitude;
        this.current_longitude=current_longitude;
    }
    public List<SearchNameDao> getParseJsonWCF(String sName)
    {
        List<SearchNameDao> ListData = new ArrayList<SearchNameDao>();
        try {
            String temp=sName.replace(" ", "%20");
            URL js = new URL("http://demo.ziamthai.com/index.php/shopInfo/searchShopInfo/"+temp);
            URLConnection jc = js.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(jc.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            JSONArray jsonArray = jsonResponse.getJSONArray("data");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject r = jsonArray.getJSONObject(i);
//                ListData.add(new SearchNameDao(r.getString("id"),r.getString("active"),r.getString("code"),r.getString("name"),r.getString("detail"),r.getString("desc"),r.getString("address"),r.getString("zipcode"),r.getString("maps"),r.getString("loc1"),r.getString("state"),r.getString("city"),r.getString("phone"),r.getString("website"),r.getString("email"),r.getString("imghead"),r.getString("imgfront"),r.getString("cdate"),r.getString("cuser"),r.getString("cip"),r.getString("mdata"),r.getString("muser"),r.getString("mip")));
                ListData.add(new SearchNameDao(r.getString("bssh_id"),r.getString("bssh_title"),r.getString("bssh_detail"),r.getString("bssh_address"),r.getString("bssh_maps"),r.getString("bssh_loc1"),r.getString("bssh_loc2"),r.getString("bssh_loc3"),r.getString("bssh_phone"),r.getString("bssh_website"),r.getString("bssh_email"),r.getString("bssh_imghead"),r.getString("bssh_imgfront")));
            }
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return ListData;


    }
}
