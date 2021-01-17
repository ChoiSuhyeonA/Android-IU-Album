package com.example.termproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.ViewFlipper;

import java.nio.channels.GatheringByteChannel;


public class MainActivity2 extends Activity {

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button previousBtn = findViewById(R.id.previousBtn);
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup)findViewById(R.id.toast));
                TextView text = (TextView)layout.findViewById(R.id.toastText);
                text.setText("이전 페이지로 이동");

                Toast toast = new Toast(MainActivity2.this);
                toast.setGravity(Gravity.CENTER, 0, 700);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();
                finish();
            }
        });
        Button next2Btn = findViewById(R.id.next2Btn);
        next2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toast,
                        (ViewGroup)findViewById(R.id.toast));
                TextView text = (TextView)layout.findViewById(R.id.toastText);
                text.setText("다음 페이지로 이동");

                Toast toast = new Toast(MainActivity2.this);
                toast.setGravity(Gravity.CENTER, 0, 700);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(layout);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

        Button btnPrev, btnNext;
        btnPrev = findViewById(R.id.btnPrev);
        btnNext = findViewById(R.id.btnNext);
        final ViewFlipper vFlipper = findViewById(R.id.viewFlipper);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showPrevious(); //이전화면 실행
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vFlipper.showNext(); //다음화면실행
            }
        });

    }

}
