package com.accepted.beforeceleb.Main.Detail;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.accepted.beforeceleb.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    Context mContext;
    private GoogleMap mMap;
    private Geocoder geocoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mContext = getApplicationContext();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);


        ((ImageView)findViewById(R.id.lv_logo)).setVisibility(View.GONE);
        ((TextView)findViewById(R.id.tv_toolbarTxt)).setVisibility(View.VISIBLE);

        ((ImageView)findViewById(R.id.iv_insta)).setVisibility(View.VISIBLE);
        ((ImageView)findViewById(R.id.iv_naver)).setVisibility(View.VISIBLE);
        ((TextView)findViewById(R.id.tv_toolbarTxt)).setText("억셉티드 카페");



    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        mMap = googleMap;
        geocoder = new Geocoder(this);

        String str="경기도 파주시 와동동 1411 ";
        List<Address> addressList = null;
        try {
            addressList = geocoder.getFromLocationName(str,1);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String []splitStr = addressList.get(0).toString().split(",");
        String address = splitStr[0].substring(splitStr[0].indexOf("\"") + 1,splitStr[0].length() - 2); // 주소
        String latitude = splitStr[10].substring(splitStr[10].indexOf("=") + 1); // 위도
        String longitude = splitStr[12].substring(splitStr[12].indexOf("=") + 1); // 경도

        // 좌표(위도, 경도) 생성
        LatLng point = new LatLng(Double.parseDouble(latitude), Double.parseDouble(longitude));
        // 마커 생성
        MarkerOptions mOptions2 = new MarkerOptions();
        mOptions2.title("억셉티드 카페");
        mOptions2.snippet(address);
        mOptions2.position(point);
        // 마커 추가

        mMap.addMarker(mOptions2);
        // 해당 좌표로 화면 줌
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point,15));


    }
}