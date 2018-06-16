package com.example.samsung.smartglass;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.app.Activity;
import android.widget.VideoView;

import com.vuzix.speech.VoiceControl;



public class DetailsActivity extends Activity {
    private TextView text;
    private TextView textDetail;
    private ImageView img;
    private String textArr[][]={{"Remove Window Trim and Casing",
            "Remove Old Window/Guide Track",
            "Prep/Repair New Window Opening",
            "Inspect/Replace Window Stop"},

            {"sop2.detail1","sop2.detail2","sop2.detail3","sop2.detail4"},
            {"sop3.detail1","sop3.detail2","sop3.detail3","sop3.detail4"},
            {"sop4.detail1","sop4.detail2","sop4.detail3","sop4.detail4"}};

    private String textDetails[][]={{"The first thing to do is to use a prybar to remove the window trim and jamb extension from around the old window. The jam extension is just...",
            "Unscrew the window from the jamb and remove it. Take care not to break the glass while removing. Many windows will be multiple window sashes with moving tracks on the side...",
            "With the window out of the wall, inspect the condition of the window jamb to make sure there is no structural damage. It’s not uncommon for an old window to leak, rotting out the jamb.... ",
            "The window stop is a piece of wood ripped down and placed around the exterior side of the window jamb. The function of the stop is to prevent..."},

            {"sop2.detail1","sop2.detail2","sop2.detail3","sop2.detail4"},
            {"sop3.detail1","sop3.detail2","sop3.detail3","sop3.detail4"},
            {"sop4.detail1","sop4.detail2","sop4.detail3","sop4.detail4"}};

    public int imgArr[]={0,0,R.drawable.one,R.drawable.two};
    public int video[]={R.raw.wildlife,R.raw.demo3,0,0,0};

    public int j = 0;
    public String str = "";
    public int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        /*MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);*/



        Bundle extras = getIntent().getExtras();

        if (extras.getString("string") !=null){ str = extras.getString("string");}
        if (extras !=null){ i = extras.getInt("index");}
        VideoView videoView = findViewById(R.id.videoView);
        String uriPath = "android.resource://" + getPackageName()+ "/" + video[i];
        //videoView.setVideoPath("android:resource://" + getPackageName()+ "/" + R.raw.demo2);
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        switch (i){
            case 0: videoView.setVisibility(videoView.VISIBLE);
                break;
            case 1: videoView.setVisibility(videoView.VISIBLE);
                break;
            case 2: videoView.setVisibility(videoView.INVISIBLE);
                break;
            case 3: videoView.setVisibility(videoView.INVISIBLE);
                break;
        }

        videoView.start();
        Button nextBtn = findViewById(R.id.next);
        nextBtn.setText(R.string.next);
        Button homeBtn = findViewById(R.id.home);
        homeBtn.setText(R.string.Home);
        Button previousBtn = findViewById(R.id.pre);
        previousBtn.setText(R.string.previous);
        text = findViewById(R.id.text);
        textDetail = findViewById(R.id.textdetail);
        img = findViewById(R.id.imageView);
        text.setText(textArr[i][j]);
        textDetail.setText(textDetails[i][j]);
        img.setImageResource(imgArr[i]);
        Log.d("TAG", "from detail   "+str);
        if (str.equals("next")){
            Log.d("TAG", "out  "+str);
            Log.d("TAG", "out  "+i);
            Log.d("TAG", "out  "+j++);
            Log.d("TAG", "out  "+(textArr[i].length-1));
            if (++j < (textArr[i].length-1))
            { text.setText(textArr[i][j]);
                Log.d("TAG", "in  "+str);
                Log.d("TAG", "in  "+str);
                Log.d("TAG", "in  "+i);
                Log.d("TAG", "in  "+j++);
                textDetail.setText(textDetails[i][j]);

                img.setImageResource(imgArr[i]);}
            else {
                Log.d("TAG", "else  "+str);
                j = 0;
                text.setText(textArr[i][j]);
                img.setImageResource(imgArr[i]);
                textDetail.setText(textDetails[i][j]);
            }
        }
        if (str.equals("home")){
            Log.d("TAG",str);
            Intent intent = new Intent(DetailsActivity.this,MainActivity.class);
            startActivityForResult(intent,1);
        }


       nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (j++ < (textArr[i].length-1))
                { text.setText(textArr[i][j]);
                 textDetail.setText(textDetails[i][j]);

                    img.setImageResource(imgArr[j]);}
                        else {
                        j = 0;
                        text.setText(textArr[i][j]);
                        img.setImageResource(imgArr[j]);
                    textDetail.setText(textDetails[i][j]);
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
                    textDetail.setText(textDetails[i][j]);
                } else {
                    j = (textArr.length-1);
                    Log.d("index","is   "+j);
                    text.setText(textArr[i][j]);
                    img.setImageResource(imgArr[j]);
                    textDetail.setText(textDetails[i][j]);
                }
            }
        });

    }


        }
