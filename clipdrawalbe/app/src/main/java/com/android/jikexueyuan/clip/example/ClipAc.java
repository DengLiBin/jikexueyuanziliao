package com.android.jikexueyuan.clip.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * Created by admin on 2016/3/26.
 */
public class ClipAc extends AppCompatActivity {
    private ImageView clipline, clipver, clipimg;
    private int cliplinelevel = 10000, clipverlevel = 10000, clipimaglevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliplay);

        clipline = (ImageView) findViewById(R.id.clipline);
        clipver = (ImageView) findViewById(R.id.clipver);
        clipimg = (ImageView) findViewById(R.id.clipimg);
        clipline.setImageLevel(10000);
        clipver.setImageLevel(10000);
    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cliplineadd:
                if (cliplinelevel < 10000) {
                    cliplinelevel += 200;
                }
                clipline.getDrawable().setLevel(cliplinelevel);
                break;
            case R.id.cliplinesub:
                if (cliplinelevel > 200) {
                    cliplinelevel -= 200;
                }
                clipline.getDrawable().setLevel(cliplinelevel);
                break;
            case R.id.clipveradd:
                if (clipverlevel < 10000) {
                    clipverlevel += 200;
                }
                clipver.getDrawable().setLevel(clipverlevel);
                break;
            case R.id.clipversub:
                if (clipverlevel > 200) {
                    clipverlevel -= 200;
                }
                clipver.getDrawable().setLevel(clipverlevel);
                break;
            case R.id.imgshow:
                if (clipimaglevel > 200) {
                    clipimg.post(rdisapper);
                } else {
                    clipimg.post(rshow);
                }
                break;

        }

    }

    private Runnable rshow = new Runnable() {
        @Override
        public void run() {


            if (clipimaglevel < 10000) {
                clipimaglevel += 200;
                clipimg.getDrawable().setLevel(clipimaglevel);
                clipimg.postDelayed(rshow, 100);
            }

        }
    };
    private Runnable rdisapper = new Runnable() {
        @Override
        public void run() {


            if (clipimaglevel > 200) {
                clipimaglevel -= 200;
                clipimg.getDrawable().setLevel(clipimaglevel);
                clipimg.postDelayed(rdisapper, 100);
            }

        }
    };
}
