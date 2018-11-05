package com.example.a91214.listview;

import android.content.Context;
import android.widget.AdapterView;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import  com.example.a91214.listview.R;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
   // ListView list;
    private ArrayList<Holiday>holidays;
    private static final int REQUEST_CODE_ADD_ITEM = 10;
    private TabLayout tablayout;
    private ViewPager viewPager;
    public static  ListViewAdapter listViewAdapter;
    //数据源
    private String[] titles={"地图","物价","新闻"};
    /*private static final int item1=Menu.FIRST;
    private static final int item2=Menu.FIRST+1;
    private String fileName = "yiheng.txt";
    public static ListViewAdapter listViewAdapter;
    //private ArrayAdapter<String>adapter;
    //private ArrayList<Holiday>data;
  // private MyListViewAdapter adapter;
   // private ArrayList<String>data=new ArrayList<String>();
    //private Button btn;
    private final String TAG=MainActivity.class.getName();
    private  static   int count=0;
    //private String text;*/

    @Override
    public void onCreateContextMenu(ContextMenu menu,View view, ContextMenu.ContextMenuInfo menuInfo){
    AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle("详情");
        menu.add(0,1,0,"删除");
        menu.add(0,2,0,"更多");
        super.onCreateContextMenu(menu,view,menuInfo);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo itemInfo=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case 1:
               Intent intent=new Intent(MainActivity.this,AddItemActivity.class);
               Bundle bundle=new Bundle();
                bundle.putString("name","胡萝卜");
               intent.putExtras(bundle);
                startActivityForResult(intent,REQUEST_CODE_ADD_ITEM);


                break;

                /*int pos=(int)adapter.getItemId(menuInfo.position);
                if(data.remove(pos)!= null){
                    System.out.println("success");*/
                    // saveObject(this,data,fileName);


                //adapter.notifyDataSetChanged();
               // Toast.makeText(getApplicationContext(),"删除此项",Toast.LENGTH_SHORT).show();

                //break;
            case 2:
                listViewAdapter.removeItem(itemInfo.position);
                listViewAdapter.notifyDataSetChanged();



                break;
                default:
                    break;
        }
        return super.onContextItemSelected(item);
    }

    public class ListViewAdapter extends BaseAdapter{
        ArrayList<View> itemViews;
        //初始化Listview
        public  ListViewAdapter(ArrayList<Holiday> holidays){
            itemViews=new ArrayList<View>(holidays.size());
            for(int i=0;i<holidays.size();++i){
                itemViews.add(makeItemView(holidays.get(i).getName(),holidays.get(i).getPrice()+"节日"+holidays.get(i).getDay(),holidays.get(i).getPictureId()));

            }
        }
        public void addItem(String itemTitle){
            Holiday holiday=new Holiday();
            holiday.setName(itemTitle);
            holiday.setDay(new Date());
            holiday.setPictureId(R.drawable.a1);
            holiday.setPrice(1);
            holidays.add(holiday);
            HolidayOperater operater=new HolidayOperater();
            operater.saveObject(MainActivity.this.getBaseContext(),holidays);
           // View view=makeItemView(itemTitle,holiday.getPrice()+"日期"+holiday.getDay());
            View view=makeItemView(itemTitle
                    ,holiday.getPrice()+"元 "+holiday.getDay()
                    ,holiday.getPictureId());
            itemViews.add(view);
        }
        public void  removeItem(int position){
            itemViews.remove(position);
            holidays.remove(position);
            HolidayOperater operater=new HolidayOperater();
            operater.saveObject(MainActivity.this.getBaseContext(),holidays);

        }
        public int getCount(){
            return  itemViews.size();
        }
        public View getItem(int position){
            return  itemViews.get(position);
        }
        public long getItemId(int position){
            return  position;
        }
        private View makeItemView(String strTitle,String strText,int resId)
        {
            LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View itemview= inflater.inflate(R.layout.listviewitem,null);
            TextView title=(TextView)itemview.findViewById(R.id.itemTitle);
            title.setText(strText);
            TextView text=(TextView)itemview.findViewById(R.id.itemText);
            text.setText(strText);
            ImageView image=(ImageView)itemview.findViewById(R.id.itemImage);
            image.setImageResource(resId);
            return itemview;
        }
        public  View getView(int position,View convertView,ViewGroup parent){
            return itemViews.get(position);
        }}


   /* @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {


        Bundle bundle=data.getExtras();
        String str=bundle.getString("back");
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();


    }*/
   @Override
   protected void onActivityResult(int requestCode,int resultCode,Intent data){
       super.onActivityResult(requestCode, resultCode, data);
       switch (requestCode){
           case  REQUEST_CODE_ADD_ITEM:
               if(resultCode==RESULT_OK){
                   String name=data.getStringExtra("name");
                   listViewAdapter.addItem(name);
                   listViewAdapter.notifyDataSetChanged();
               }
               break;
       }
   }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // list=(ListView)findViewById(R.id.ListView01);
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent=new Intent(MainActivity.this,AddItemActivity.class);
             Bundle bundle=new Bundle();
             bundle.putString("name","清明节");
             intent.putExtras(bundle);
             startActivityForResult(intent,REQUEST_CODE_ADD_ITEM);


            };

        });
        //实现修改后的数据序列化存储
        HolidayOperater operater=new HolidayOperater();
        holidays=operater.readObject(getBaseContext());
        if(holidays==null){
            holidays=new ArrayList<Holiday>();


        }
        Holiday holiday=new Holiday();
        holiday.setName("y");
        holiday.setPictureId(R.drawable.a2);
        holiday.setDay(new Date());
        holiday.setPrice(100);
        holidays.add(holiday);
        listViewAdapter=new ListViewAdapter(holidays);
        LayoutInflater inflater=(LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(R.layout.holidaycontent,null);




        tablayout=(TabLayout) findViewById(R.id.tablayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
      MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager());
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        viewPager.setAdapter(myPagerAdapter);
        tablayout.setupWithViewPager(viewPager);
        LinearLayout linearLayout=(LinearLayout)tablayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
       // linearLayout.setDividerDrawable(ContextCompat.getDrawable(this,R.drawable.layout_divider_vertical));


    }


       // btn=(Button)findViewById(R.id.button2);
     // data=(ArrayList<String>) readObject(this,fileName);
       //data=new ArrayList<String>(Arrays.asList("(1)春节","(2)元宵节","(3)清明节","(4)重阳节","(5)国庆节"));
       // registerForContextMenu(list);
        //adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        //adapter=new MyListViewAdapter(MainActivity.this);
       // list.setAdapter(adapter);
       // list.setOnItemClickListener(new mItemClick());
        //btn.setOnClickListener(new mClick());
       // saveObject(this,data,fileName);
        //data=(ArrayList<String>) readObject(this,fileName);



    //建立和配置菜单项




    //配置MyPagerAdapter
private MapViewFragment mapViewFragment=null;
class  MyPagerAdapter extends FragmentPagerAdapter{
public MyPagerAdapter(FragmentManager fm){
    super(fm);
}
@Override
    public  CharSequence getPageTitle(int position){
    return  titles[position];
}
@Override
    public Fragment getItem(int position){
        if(position==0){
          MapViewFragment  mapViewFragment=new MapViewFragment();
                    return mapViewFragment;
        } if(position==1)
    {
        ListViewFragment fragment= new ListViewFragment();
        return fragment;
    }
    else {
        WebViewFragment webViewFragment = new WebViewFragment();
        return webViewFragment;
    }
}
@Override
    public int getCount(){
        return titles.length;
}
}


      class mListViewItemClick implements   android.widget.AdapterView.OnItemClickListener{
    @Override
    public void onItemClick(AdapterView<?>adapterView,View view,int i,long l){
        Toast.makeText(MainActivity.this,"你选择的项目是"+((TextView)view).getText(),Toast.LENGTH_SHORT).show();
    }
}

@Override
    protected void  onDestroy(){
    super.onDestroy();
    if(mapViewFragment!=null)
        mapViewFragment.MDestroy();

}
@Override
    protected  void onResume(){
        super.onResume();
        if(mapViewFragment!=null)
            mapViewFragment.MResume();
}
@Override
    protected  void  onPause(){
        super.onPause();
        if(mapViewFragment!=null)
            mapViewFragment.MPause();
}



}

//增加项目


   /* public void add(View view){


        data.add("新的项目");
        adapter.notifyDataSetChanged();
       //saveObject(this,data,fileName);*/





    /*class mItemClick implements AdapterView.OnItemClickListener{
        @Override
        public  void onItemClick(AdapterView<?>arg0,View argl,int arg2,long arg3)
        {
            View arg=argl;
            Toast.makeText(MainActivity.this,"你选择的项目是："+((TextView)arg).getText(),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,BActivity.class);
            Bundle bundle=new Bundle();

            bundle.putString("text",((TextView)arg).getText().toString());
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
            saveObject(MainActivity.this,data,fileName);



            ;
        }
    }*/
    /*
public static  void saveObject(Context context,Serializable ser,String file){
    FileOutputStream fos=null;
    ObjectOutputStream oos=null;
    try {
        fos=context.openFileOutput(file,Context.MODE_PRIVATE);
        oos=new ObjectOutputStream(fos);
        oos.writeObject(ser);
        oos.flush();
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        try {
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }}}




    public static Serializable readObject(Context context,String file) {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = context.openFileInput(file);
            ois = new ObjectInputStream(fis);
            return (Serializable) ois.readObject();


        } catch (FileNotFoundException e) {

        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof InvalidClassException) {
                File data = context.getFileStreamPath(file);
                data.delete();


            }


        } finally {
            try {
                ois.close();

            } catch (Exception e) {


            }
            try {
                fis.close();
            } catch (Exception e) {
            }


        }
        return null;
    }*/






