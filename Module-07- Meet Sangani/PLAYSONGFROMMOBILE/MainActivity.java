package com.example.multimedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST_CODE = 100;
    private MediaPlayer mediaPlayer;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        checkPermission();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(view);
            }
        });
    }

    private void checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_CODE);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    Toast.makeText(this, "Thank you", Toast.LENGTH_SHORT).show();
                } else {
                    // Permission denied
                }
            }
        }
    }

    public void playSong(View view) {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();
            File file = Environment.getExternalStorageDirectory();
            file = new File(file, "VidMate\\download\\song1.mp3");
            btn1.setText("PAUSE");
            if (file.exists()) {
                Uri uri = Uri.fromFile(file);
                mediaPlayer = MediaPlayer.create(this, uri);
                mediaPlayer.start();
            }
        } else {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                btn1.setText("PLAY");
            } else {
                mediaPlayer.start();
                btn1.setText("PAUSE");

            }
        }
    }
}