package com.revenue_express.ziamthai.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.revenue_express.ziamthai.R;

import java.util.ArrayList;



/**
 * Created by chet_cpe on 2/8/2559.
 */
public class StateAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    int nPosition;
    public StateAdapter(Context context, ArrayList<String> arrayState){
        this.context = context;
        this.arrayList = arrayState;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public int getPosition(){
        return nPosition;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            LayoutInflater mInflater =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_state,parent,false);
            TextView tvState = null;
            tvState = (TextView) convertView.findViewById(R.id.tvState);
            tvState.setText(arrayList.get(position));


//            tvState.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(position == 1){
//                        Intent intent = new Intent(context,StateActivity.class);
//                        intent.putExtra("NameState",String.valueOf(arrayList.get(position)));
//                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(intent);
//                    }
//                }
//            });

        }
        nPosition = position;


        return convertView;
    }
}
