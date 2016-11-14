package com.revenue_express.ziamthai.fragment;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.revenue_express.ziamthai.ApplicationMainActivity;
import com.revenue_express.ziamthai.R;
import com.revenue_express.ziamthai.RestaurantActivity;
import com.revenue_express.ziamthai.SearchActivity;
import com.revenue_express.ziamthai.adapter.RecommendAdapter;
import com.revenue_express.ziamthai.dao.DataRecommendDao;
import com.revenue_express.ziamthai.dao.RecommendItemDao;
import com.revenue_express.ziamthai.dao.RecommendListItemDao;
import com.revenue_express.ziamthai.manager.HttpManager;
import com.revenue_express.ziamthai.manager.RecommendListManager;
import com.revenue_express.ziamthai.view.RecommendListItem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by chet_cpe on 2/8/2559.
 */
public class RecommendFragment extends Fragment {
    GridView LV_Recommend ;
    RecommendAdapter listAdepter;
    RecommendListItemDao dao;
    SwipeRefreshLayout swipeRefreshLayout;

    public RecommendFragment() {
        super();
    }

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recommend, container, false);
        initInstances(rootView);

        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        LV_Recommend = (GridView) rootView.findViewById(R.id.LV_Recommend);
        listAdepter = new RecommendAdapter();
        LV_Recommend.setAdapter(listAdepter);

        swipeRefreshLayout = (SwipeRefreshLayout)rootView.findViewById(R.id.swipeRefreshLayout);

        reloadData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reloadData();
            }
        });
        LV_Recommend.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                swipeRefreshLayout.setEnabled(firstVisibleItem == 0);
            }
        });

        LV_Recommend.setClickable(true);
        LV_Recommend.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a = dao.getData().get(position).getName();
                Toast.makeText(getActivity(), a, Toast.LENGTH_LONG).show();
                ArrayList<DataRecommendDao> obj = new ArrayList<DataRecommendDao>();

                DataRecommendDao temp = new DataRecommendDao();
                temp.setName(String.valueOf(dao.getData().get(position).getName()));
                temp.setAddress(String.valueOf(dao.getData().get(position).getAddress()));
                temp.setCity(String.valueOf(dao.getData().get(position).getCity()));
                temp.setCountry(String.valueOf(dao.getData().get(position).getCountry()));
                temp.setDetail(String.valueOf(dao.getData().get(position).getDetail()));
                temp.setId(String.valueOf(dao.getData().get(position).getId()));
                temp.setImage(String.valueOf(dao.getData().get(position).getImage()));
                temp.setMap(String.valueOf(dao.getData().get(position).getMap()));
                temp.setPhone(String.valueOf(dao.getData().get(position).getPhone()));
                temp.setState(String.valueOf(dao.getData().get(position).getState()));
                obj.add(temp);

                Intent intent = new Intent(getActivity(), RestaurantActivity.class);
                intent.putExtra("Temp",obj);
                startActivity(intent);
            }
        });
    }

    private void reloadData() {
        Call<RecommendListItemDao> call = HttpManager.getInstance().getService().loadRecommendList();
        call.enqueue(new Callback<RecommendListItemDao>() {
            @Override
            public void onResponse(Call<RecommendListItemDao> call,
                                   Response<RecommendListItemDao> response) {
                swipeRefreshLayout.setRefreshing(false);
                if (response.isSuccessful()){
                   dao = response.body();
                    RecommendListManager.getInstance().setDao(dao);
                    listAdepter.notifyDataSetChanged();
//                    Toast.makeText(Contextor.getInstance().getContext(),
//                    Toast.makeText(getContext(),
                    Toast.makeText(getActivity(),
                            dao.getData().get(0).getName(),

                            Toast.LENGTH_LONG)
                            .show();
                } else {
                    try {
//                        Toast.makeText(Contextor.getInstance().getContext(),
//                        Toast.makeText(getContext(),
                        Toast.makeText(getActivity(),
                                response.errorBody().string(),
                                Toast.LENGTH_LONG)
                                .show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<RecommendListItemDao> call,
                                  Throwable t) {
//                Toast.makeText(Contextor.getInstance().getContext(),
//                Toast.makeText(getContext(),
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(),
                        t.toString(),
                        Toast.LENGTH_LONG)
                        .show();

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }
}
