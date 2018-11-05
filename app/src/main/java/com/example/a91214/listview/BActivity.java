/*package com.example.a91214.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BActivity extends AppCompatActivity {
private Button btn2;
private EditText txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt2=(EditText)findViewById(R.id.edittext1);
        Bundle bundle=this.getIntent().getExtras();
        String str=bundle.getString("text");
        txt2.setText(str);
        btn2=(Button)findViewById(R.id.button1);
        btn2.setOnClickListener(new btnlock());


            }


    class btnlock implements View.OnClickListener{
        @Override
        public void onClick(View v){


                    Intent intent2=new Intent();
                   Bundle bundle=new Bundle();
                    intent2.setClass(BActivity.this,MainActivity.class);
                    bundle.putString("back",txt2.getText().toString());
                    intent2.putExtras(bundle);
                    setResult(0,intent2);
                    finish();


            }
        }}
*/


