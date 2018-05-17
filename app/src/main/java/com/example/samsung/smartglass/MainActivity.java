package com.example.samsung.smartglass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vuzix.speech.VoiceControl;



public class MainActivity extends Activity {
    private ListView list;
    private String textArr[]={"How to Install a New Window","How to Install ....","How to Install ....","How to Install ...."};
    private MyVoiceControl mVC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        mVC = new MyVoiceControl(this);
        if (mVC != null) {
            mVC.on();
           /* Toast.makeText(this,"u said"+mVC,Toast.LENGTH_SHORT).show();
            return; */
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,textArr){

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = super.getView(position, convertView, parent);

            TextView textView = view.findViewById(android.R.id.text1);

            textView.setTextColor(Color.BLACK);

            return view;
        }};

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
            intent.putExtra("index",position);
            startActivityForResult(intent,1);
            }
        });

    }
    public class MyVoiceControl extends VoiceControl {
        public MyVoiceControl(Context context) {
            super(context);
        }
        protected void onRecognition(String result) {
            Toast.makeText(MainActivity.this,"Received: "+result,Toast.LENGTH_SHORT).show();}
    }
}


