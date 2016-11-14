package com.revenue_express.ziamthai.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.inthecheesefactory.thecheeselibrary.view.BaseCustomViewGroup;
import com.inthecheesefactory.thecheeselibrary.view.state.BundleSavedState;
import com.revenue_express.ziamthai.R;
import com.squareup.picasso.Picasso;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DealListItem extends BaseCustomViewGroup {
    TextView tvName;
    TextView tvState;
    ImageView imgItem;

    public DealListItem(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public DealListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public DealListItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public DealListItem(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.item_deal, this);

       int a = 0;
    }

    private void initInstances() {
        // findViewById here
        tvName = (TextView)findViewById(R.id.tvName);
        tvState = (TextView)findViewById(R.id.tvState);
        imgItem = (ImageView)findViewById(R.id.imgItem);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * 2 / 3;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
                height,
                MeasureSpec.EXACTLY
        );
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
        setMeasuredDimension(width,height);
    }


    public void setTvName(String text){
        tvName.setText(text);
    }
    public void setTvState(String text){
        tvState.setText(text);
    }
    public void setImgItem(String url){
        //TODO: Load Image
//        Glide.with(getContext())
//                .load("http://demo.ziamthai.com/admin/uploads/header/20160915174909046998.jpg")
//                .placeholder(R.drawable.loading)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(imgItem);
        Picasso.with(getContext()).load(url).placeholder(R.drawable.loading).into(imgItem);
    }
}
