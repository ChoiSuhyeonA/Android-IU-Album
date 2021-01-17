package com.example.termproject;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Album1Activity extends Activity {



    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_info);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Switch switch1 = findViewById(R.id.switch1);


        final String[] list= {"분홍신","ModernTimes", "입술사이"};
        ListView list1 = findViewById(R.id.listView1);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Album1Activity.this, android.R.layout.simple_list_item_single_choice, list);
        list1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list1.setAdapter(adapter1);
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            switch(i){
                case 0:    final MediaPlayer mPlayer = MediaPlayer.create(Album1Activity.this, R.raw.song_11);
                    switch1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(switch1.isChecked()==true){
                                mPlayer.start();
                            }else
                                mPlayer.stop();

                        }
                    }); break;
                case 1: final MediaPlayer mPlayer2 = MediaPlayer.create(Album1Activity.this, R.raw.song_12);
                    switch1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(switch1.isChecked()==true){
                                mPlayer2.start();
                            }else
                                mPlayer2.stop();

                        }
                    }); break;
                case 2: final MediaPlayer mPlayer3 = MediaPlayer.create(Album1Activity.this, R.raw.song_13);
                    switch1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(switch1.isChecked()==true){
                                mPlayer3.start();
                            }else
                                mPlayer3.stop();

                        }
                    }); break;
            }

            }
        });

    }

}
