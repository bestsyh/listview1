package com.example.a91214.listview;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.Nullable;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by 91214 on 2018/10/31.
 */

public class ListViewFragment extends Fragment{

    public ListViewFragment() {
    }
    
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View contentView = inflater.inflate(R.layout.fragment_list_view, container, false);
        ListView listview= (ListView)contentView.findViewById(R.id.listview_goods_price);
        listview.setAdapter(MainActivity.listViewAdapter);
        listview.setOnItemClickListener(new mItemClick());
        registerForContextMenu(listview);
        return  contentView;

    }
    class mItemClick implements AdapterView.OnItemClickListener{
   @Override
   public  void onItemClick(AdapterView<?>arg0,View argl,int arg2,long arg3){

Toast.makeText(getActivity(),"你选择的项目是"+arg2,Toast.LENGTH_SHORT).show();
    }
}}
