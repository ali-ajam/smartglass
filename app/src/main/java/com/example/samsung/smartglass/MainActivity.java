package com.example.samsung.smartglass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends Activity {
    private TextView text;
    private ImageView img;
    private String textArr[]={"sop1","sop2","sop3","sop4"};
    public int imgArr[]={R.drawable.img1,R.drawable.noimg,R.drawable.img2,R.drawable.noimg};
    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nextbtn = findViewById(R.id.next);
        nextbtn.setText(R.string.next);
        Button previousbtn = findViewById(R.id.pre);
        previousbtn.setText(R.string.previous);
        text = findViewById(R.id.text);
        img = findViewById(R.id.imageView);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < textArr.length){
                    text.setText(textArr[i]);
                    img.setImageResource(imgArr[i]);
                    i++;}
                else {
                    i = 0;
                    text.setText(textArr[i]);
                    img.setImageResource(imgArr[i]);
                }
            }
        });
        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i < 1) {
                    text.setText(textArr[i]);
                    img.setImageResource(imgArr[i]);
                    i = textArr.length;
                } else {
                    i--;
                    text.setText(textArr[i]);
                    img.setImageResource(imgArr[i]);
                }
            }
        });
    }}

