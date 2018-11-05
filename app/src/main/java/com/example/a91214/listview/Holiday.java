package com.example.a91214.listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Holiday implements Serializable{
    private  String name;
    private Date day;
    private int pictureId;
    private  double price;
    public   void  setName(String name){
        this.name=name;
    }
    public void setDay(Date  day){
        this.day=day;
    }
    public Date getDay(){
        return  day;
    }
    public   String getName(){
        return  name;
    }
    public  int getPictureId(int pictureId){
         return pictureId;
    }
    public  void setPictureId(int pictureId){
        this.pictureId=pictureId;
    }
    public  int getPictureId(){
        return pictureId;
    }
    public double getPrice(){
        return  price;
    }
    public  void  setPrice(double price){
        this.price=price;
    }



}
/*
public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    private List<String>datas=new ArrayList<String>();

     MyListViewAdapter (Context context){
        this.context=context;
    }

public void addData(String text){
        if(datas != null){
            datas.add(text);

        }
}

public void  delData(){
    if(datas!= null&& datas.size()>0)
        datas.remove(datas.size()-1);
}
@Override
public int getCount(){
    if(datas==null)
        return  0;
    return  datas.size();
}
@Override
public   Object getItem(int position){
    return  datas.get(position);
}
@Override
public  long getItemId(int  position){
    return  position;
}
@Override
public View getView(int position, View converView, ViewGroup parent){


    return converView;
}*/