package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

//
public class MainActivity2 extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    String url = "https://nejadhari.000webhostapp.com/SONG/songggg.mp3";
    Button btn1;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn1 = findViewById(R.id.btn1);

         btn1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 playSong(view);
             }
         });

    }
    public void playSong(View view) {
        if(mediaPlayer==null){
            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(this);
                btn1.setText("PAUSE");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            if (mediaPlayer.isPlaying()) {
                btn1.setText("PLAY");
                mediaPlayer.pause();
            }
            else {
                mediaPlayer.start();
                btn1.setText("PAUSE");
            }

        }

    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mediaPlayer.start();
    }
}