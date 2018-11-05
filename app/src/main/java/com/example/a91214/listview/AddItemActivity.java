package com.example.a91214.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

public class AddItemActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Bundle bundle=this.getIntent().getExtras();
        String name=bundle.getString("name");
        editText=(EditText)this.findViewById(R.id.holiday_add);
        editText.setText(name);
        Button buttonAdd=(Button)this.findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new  ButtonAddClick());
    }
    private class ButtonAddClick implements View.OnClickListener{
        @Override
        public  void  onClick(View view){
            Intent intent=new Intent();
            intent.putExtra("name",String.valueOf(editText.getText()));
            Log.i("text",String.valueOf(editText.getText()));
            setResult(RESULT_OK,intent);
            AddItemActivity.this.finish();
        }
    }
}

