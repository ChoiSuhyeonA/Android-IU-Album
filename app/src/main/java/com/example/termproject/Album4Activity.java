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


public class Album4Activity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_info4);

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        final Switch switch4 = findViewById(R.id.switch4);

        final String[] list= {"LovePoem","Blueming", "자장가"};
        ListView list4 = findViewById(R.id.listView4);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Album4Activity.this, android.R.layout.simple_list_item_single_choice, list);
        list4.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list4.setAdapter(adapter1);
        list4.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:    final MediaPlayer mPlayer = MediaPlayer.create(Album4Activity.this, R.raw.song_41);
                        switch4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch4.isChecked()==true){
                                    mPlayer.start();
                                }else
                                    mPlayer.stop();

                            }
                        }); break;
                    case 1: final MediaPlayer mPlayer2 = MediaPlayer.create(Album4Activity.this, R.raw.song_42);
                        switch4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch4.isChecked()==true){
                                    mPlayer2.start();
                                }else
                                    mPlayer2.stop();

                            }
                        }); break;
                    case 2: final MediaPlayer mPlayer3 = MediaPlayer.create(Album4Activity.this, R.raw.song_43);
                        switch4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch4.isChecked()==true){
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
