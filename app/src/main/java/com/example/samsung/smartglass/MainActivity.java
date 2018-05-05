package com.example.samsung.smartglass;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
    private Button nextbtn;
    private Button previousbtn;
    private TextView text;
    private String textArr[]={"sop1","sop2","sop3","sop4"};
    public int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextbtn = findViewById(R.id.next);
        nextbtn.setText(R.string.next);
        previousbtn = findViewById(R.id.pre);
        previousbtn.setText(R.string.previous);
        text = findViewById(R.id.text);

    }
    public void next(View view) {
        if (i < textArr.length){
        text.setText(textArr[i]);
        i++;}
        else {
        i = 0;
            text.setText(textArr[i]);
        }
        }
    public void previous(View view) {
        if (i < 1){
            text.setText(textArr[i]);
            i=textArr.length;}
        else {
            i--;
            text.setText(textArr[i]);
        }
    }
    }

