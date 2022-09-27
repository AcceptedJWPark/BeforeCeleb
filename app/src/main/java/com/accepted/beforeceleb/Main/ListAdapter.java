package com.accepted.beforeceleb.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

import com.accepted.beforeceleb.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private Activity activity;
    private ArrayList<ListItem> arrayList;

    private ViewPager2 sliderViewPager;



    public ListAdapter(Context mContext, Activity activity, ArrayList<ListItem> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return  arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_child, viewGroup, false);

            holder = new ViewHolder();

            sliderViewPager = view.findViewById(R.id.sliderViewPager);

            holder.indicator3 = view.findViewById(R.id.indicator);
            holder.indicator3.setViewPager(sliderViewPager);
            holder.tv_title = view.findViewById(R.id.tv_title);
            holder.tv_explain = view.findViewById(R.id.tv_explain);
            holder.tv_address = view.findViewById(R.id.address);
            holder.tv_phone = view.findViewById(R.id.phone);
            holder.tv_date = view.findViewById(R.id.date);
            holder.iv_insta = view.findViewById(R.id.iv_insta);
            holder.iv_naver = view.findViewById(R.id.iv_naver);

            holder.tv_title.setText(arrayList.get(i).getTitle());
            holder.tv_explain.setText(arrayList.get(i).getExplain());
            holder.tv_address.setText(arrayList.get(i).getAddress());
            holder.tv_phone.setText(arrayList.get(i).getPhone());
            holder.tv_date.setText(arrayList.get(i).getDate());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, com.accepted.beforeceleb.Main.Detail.MainActivity.class);
                    mContext.startActivity(intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });
            view.setTag(holder);

        } else {
            holder = (ViewHolder)view.getTag();
            view.setTag(holder);
        }

        sliderViewPager = view.findViewById(R.id.sliderViewPager);
        holder.indicator3.setViewPager(sliderViewPager);

        holder.tv_title = view.findViewById(R.id.tv_title);
        holder.tv_explain = view.findViewById(R.id.tv_explain);
        holder.tv_address = view.findViewById(R.id.address);
        holder.tv_phone = view.findViewById(R.id.phone);
        holder.tv_date = view.findViewById(R.id.date);
        holder.iv_insta = view.findViewById(R.id.iv_insta);
        holder.iv_naver = view.findViewById(R.id.iv_naver);

        holder.tv_title.setText(arrayList.get(i).getTitle());
        holder.tv_explain.setText(arrayList.get(i).getExplain());
        holder.tv_address.setText(arrayList.get(i).getAddress());
        holder.tv_phone.setText(arrayList.get(i).getPhone());
        holder.tv_date.setText(arrayList.get(i).getDate());




        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, com.accepted.beforeceleb.Main.Detail.MainActivity.class);
                mContext.startActivity(intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

        return view;
    }

    static class ViewHolder {
        TextView tv_title;
        ImageView iv_insta;
        ImageView iv_naver;
        TextView tv_explain;
        TextView tv_address;
        TextView tv_phone;
        TextView tv_date;
        CircleIndicator3 indicator3;
    }


}
