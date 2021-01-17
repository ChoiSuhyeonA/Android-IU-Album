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


public class Album2Activity extends Activity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_info2);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final Switch switch2 = findViewById(R.id.switch2);


        final String[] list= {"스물셋","무릎", "Zeze"};
        ListView list2 = findViewById(R.id.listView2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(Album2Activity.this, android.R.layout.simple_list_item_single_choice, list);
        list2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list2.setAdapter(adapter1);
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:    final MediaPlayer mPlayer = MediaPlayer.create(Album2Activity.this, R.raw.song_21);
                        switch2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch2.isChecked()==true){
                                    mPlayer.start();
                                }else
                                    mPlayer.stop();

                            }
                        }); break;
                    case 1: final MediaPlayer mPlayer2 = MediaPlayer.create(Album2Activity.this, R.raw.song_22);
                        switch2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch2.isChecked()==true){
                                    mPlayer2.start();
                                }else
                                    mPlayer2.stop();

                            }
                        }); break;
                    case 2: final MediaPlayer mPlayer3 = MediaPlayer.create(Album2Activity.this, R.raw.song_23);
                        switch2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if(switch2.isChecked()==true){
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
