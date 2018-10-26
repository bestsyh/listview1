package com.example.a91214.listview;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ContextMenu.ContextMenuInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    ListView list;
    private TableLayout tableLayout;
    private ViewPager viewPager;
    private static final int item1=Menu.FIRST;
    private static final int item2=Menu.FIRST+1;
    private String fileName = "yiheng.txt";
    private ArrayAdapter<String>adapter;
    //private ArrayList<Holiday>data;
  // private MyListViewAdapter adapter;
    private ArrayList<String>data=new ArrayList<String>();
    //private Button btn;
    private final String TAG=MainActivity.class.getName();
    private  static   int count=0;
    //private String text;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=(ListView)findViewById(R.id.ListView01);


       // btn=(Button)findViewById(R.id.button2);
      data=(ArrayList<String>) readObject(this,fileName);
       //data=new ArrayList<String>(Arrays.asList("(1)春节","(2)元宵节","(3)清明节","(4)重阳节","(5)国庆节"));
        registerForContextMenu(list);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        //adapter=new MyListViewAdapter(MainActivity.this);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new mItemClick());
        //btn.setOnClickListener(new mClick());
        saveObject(this,data,fileName);
        //data=(ArrayList<String>) readObject(this,fileName);
    }

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
    }

//建立和配置菜单项
    @Override
    public void onCreateContextMenu(ContextMenu menu,View view, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("详情");
        menu.add(0,item1,0,"删除");
        menu.add(0,item2,0,"更多");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo menuInfo=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case item1:
                int pos=(int)adapter.getItemId(menuInfo.position);
                if(data.remove(pos)!= null){
                    System.out.println("success");
                   saveObject(this,data,fileName);
                }
                else{
                    System.out.println("failed");

                }
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"删除此项",Toast.LENGTH_SHORT).show();

                break;
            case item2:
                break;
        }
        return true;
    }
//增加项目


    public void add(View view){


        data.add("新的项目");
        adapter.notifyDataSetChanged();
       saveObject(this,data,fileName);


    }


    class mItemClick implements AdapterView.OnItemClickListener{
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
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {


        Bundle bundle=data.getExtras();
        String str=bundle.getString("back");
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();


    }}




