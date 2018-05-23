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
import com.vuzix.speech.VoiceControl;



public class MainActivity extends Activity {
    private ListView list;
    private String textArr[]={"1. How to Install a New Window","How to Install ....","2. How to Install ....","3. How to Install ...."};
    private MyVoiceControl mVC;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        mVC = new MyVoiceControl(this);
        if (mVC != null) {
            mVC.on();
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
            if (result == "1"){
                        pos = 1;
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("index",pos);
                startActivityForResult(intent,1);
            }
        }
    }
}


