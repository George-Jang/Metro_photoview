package com.example.metro_photoview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.metropicv2);
        PhotoViewAttacher mAttacher = new PhotoViewAttacher(photoView);
        mAttacher.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                //String msg = "터치 영역 : " +x+" / " +y;

                //Toast. makeText(MainActivity. this, msg, Toast.LENGTH_SHORT ).show();
                if( 0.3871634<x && x< 0.40196878 && 0.41602868<y && y<0.44616857){
                    Toast. makeText(MainActivity. this, "120", Toast.LENGTH_SHORT ).show();
                }

            }
        });
    }
}