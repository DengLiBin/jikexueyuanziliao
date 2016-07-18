package com.android.jikexueyuan.clip.example;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by admin on 2016/3/26.
 */
public class ScaleAc extends AppCompatActivity {

    private ImageView scaleimg;
    private int scalelevel = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scalelay);
        scaleimg = (ImageView) findViewById(R.id.scaleimg);
        scaleimg.getDrawable().setLevel(10000);
    }

    public void onClick(View v) {
        if (scalelevel > 100) {
            scaleimg.post(rdisapper);
        } else {
            scaleimg.post(rshow);
        }
    }

    private Runnable rshow = new Runnable() {
        @Override
        public void run() {


            if (scalelevel < 10000) {
                scalelevel += 100;
                scaleimg.getDrawable().setLevel(scalelevel);
                scaleimg.postDelayed(rshow, 100);
            }

        }
    };
    private Runnable rdisapper = new Runnable() {
        @Override
        public void run() {


            if (scalelevel > 100) {
                scalelevel -= 100;
                scaleimg.getDrawable().setLevel(scalelevel);
                scaleimg.postDelayed(rdisapper, 100);
            }

        }
    };
}
