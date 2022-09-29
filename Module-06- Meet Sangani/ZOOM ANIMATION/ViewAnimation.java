package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ViewAnimation extends AppCompatActivity {



    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);

        imageView = findViewById(R.id.img);

        Animation animation = AnimationUtils.loadAnimation(ViewAnimation.this,R.anim.zoom);
        imageView.startAnimation(animation);
    }
}