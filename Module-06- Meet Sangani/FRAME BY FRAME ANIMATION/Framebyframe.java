package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class Framebyframe extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framebyframe);

        imageView=findViewById(R.id.imageView);
        animationDrawable=(AnimationDrawable)(imageView.getBackground());

        if(animationDrawable.isRunning()){
            animationDrawable.stop();
        }
        else{
            animationDrawable.start();
        }
    }
}