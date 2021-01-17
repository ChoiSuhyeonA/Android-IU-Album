package com.example.termproject;


import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;


public class Album3Activity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_info3);

        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final Switch switch3 = findViewById(R.id.switch3);

        final String[] list= {"Palette","이런엔딩", "이름에게"};
        ListView list3 = findViewById(R.id.listView3);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Album3Activity.this, android.R.layout.simple_list_item_single_choice, list);
        list3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list3.setAdapter(adapter1);
        list3.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:    final MediaPlayer mPlayer = MediaPlayer.create(Album3Activity.this, R.raw.song_31);
                        switch3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch3.isChecked()==true){
                                    mPlayer.start();
                                }else
                                    mPlayer.stop();

                            }
                        }); break;
                    case 1: final MediaPlayer mPlayer2 = MediaPlayer.create(Album3Activity.this, R.raw.song_32);
                        switch3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch3.isChecked()==true){
                                    mPlayer2.start();
                                }else
                                    mPlayer2.stop();

                            }
                        }); break;
                    case 2: final MediaPlayer mPlayer3 = MediaPlayer.create(Album3Activity.this, R.raw.song_33);
                        switch3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch3.isChecked()==true){
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
