package com.example.a91214.listview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Toast;

import com.baidu.mapapi.map.*;
import com.baidu.mapapi.model.LatLng;

/**
 * Created by 91214 on 2018/10/31.
 */
public  class MapViewFragment extends Fragment{

     @Nullable
    MapView mMapView=null;
     @Override
     public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container , @Nullable Bundle savedInstanceState){
   View contentView =inflater.inflate(R.layout.fragment_map_view,container,false);
   mMapView=(MapView)contentView.findViewById(R.id.bmapView);
   BaiduMap mBaidumap=mMapView.getMap();
         LatLng cenpt=new LatLng(22.2559,113.541112);
         MapStatus mMapStatus=new MapStatus.Builder().target(cenpt).zoom(17).build();
         MapStatusUpdate mMapStatusUpdate=MapStatusUpdateFactory.newMapStatus(mMapStatus);
         mBaidumap.setMapStatus(mMapStatusUpdate);
         BitmapDescriptor bitmap=BitmapDescriptorFactory.fromResource(R.drawable.a1);
         MarkerOptions markerOption=new MarkerOptions().icon(bitmap).position(cenpt);
         Marker marker=(Marker)mBaidumap.addOverlay(markerOption);
         OverlayOptions textOption=new TextOptions().bgColor(0xAAFFFF00).fontSize(50).fontColor(0xFFFF00FF).text("百度地图SDK").rotate(0).position(cenpt);
         mBaidumap.addOverlay(textOption);
         mBaidumap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {

             @Override
             public boolean onMarkerClick(Marker arg0) {
                 // TODO Auto-generated method stub
                 Toast.makeText(getContext(), "Marker被点击了！", Toast.LENGTH_SHORT).show();
                 return false;
             }
         });
       return contentView;
    }
    public void MDestroy() {
        if(mMapView!=null)mMapView.onDestroy();
    }
    public void MResume() {
        if(mMapView!=null)mMapView.onResume();
    }
    public void MPause() {
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        if(mMapView!=null)mMapView.onPause();
    }
}