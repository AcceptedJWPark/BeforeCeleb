package com.accepted.beforeceleb.Main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.accepted.beforeceleb.R;


public class MainActivity extends AppCompatActivity {

    Context mContext;

    View footer;

    DrawerLayout dl;
    View v_drawerlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();


        dl = (DrawerLayout)findViewById(R.id.drawer);
        v_drawerlayout = (View)findViewById(R.id.view_drawerlayout);

        ((ImageView)findViewById(R.id.lv_logo)).setVisibility(View.VISIBLE);
        ((TextView)findViewById(R.id.tv_toolbarTxt)).setVisibility(View.GONE);
        ((ImageView)findViewById(R.id.iv_sort)).setVisibility(View.VISIBLE);

        ((ImageView)findViewById(R.id.iv_sort)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dl.openDrawer(v_drawerlayout);
            }
        });


    }

    @Override
    public void onResume() {
        super.onResume();


    }


}