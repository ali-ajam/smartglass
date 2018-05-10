package com.example.samsung.smartglass;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
    private ListView list;
    private String textArr[]={"sop1","sop2","sop3","sop4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);

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
    }}

