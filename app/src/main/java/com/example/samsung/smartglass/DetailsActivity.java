package com.example.samsung.smartglass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;

public class DetailsActivity extends Activity {
    private TextView text;
    private ImageView img;
    private String textArr[][]={{"sop1.detail1","sop1.detail2","sop1.detail3","sop1.detail4"},
            {"sop2.detail1","sop2.detail2","sop2.detail3","sop2.detail4"},
            {"sop3.detail1","sop3.detail2","sop3.detail3","sop3.detail4"},
            {"sop4.detail1","sop4.detail2","sop4.detail3","sop4.detail4"}};
    public int imgArr[]={R.drawable.img1,R.drawable.noimg,R.drawable.img2,R.drawable.noimg};
    public int j = 0;
    public int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle extras = getIntent().getExtras();

        if (extras !=null){ i = extras.getInt("index");}

        Button nextBtn = findViewById(R.id.next);
        nextBtn.setText(R.string.next);
        Button homeBtn = findViewById(R.id.home);
        homeBtn.setText(R.string.Home);
        Button previousBtn = findViewById(R.id.pre);
        previousBtn.setText(R.string.previous);
        text = findViewById(R.id.text);
        img = findViewById(R.id.imageView);
        text.setText(textArr[i][j]);
        img.setImageResource(imgArr[j]);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j++ < (textArr[i].length-1)) {
                        text.setText(textArr[i][j]);
                        img.setImageResource(imgArr[j]);}
                        else {
                        j = 0;
                        text.setText(textArr[i][j]);
                        img.setImageResource(imgArr[j]);
                    }

            }});

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this,MainActivity.class);
                startActivityForResult(intent,1);
            }
        });
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j-- > 0) {
                    Log.d("index","is   "+j);
                    text.setText(textArr[i][j]);
                    img.setImageResource(imgArr[j]);
                } else {
                    j = (textArr.length-1);
                    Log.d("index","is   "+j);
                    text.setText(textArr[i][j]);
                    img.setImageResource(imgArr[j]);
                }
            }
        });
    }}
