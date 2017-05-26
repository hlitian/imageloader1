package com.tian.myimageloader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.image);
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.setImageCache(new MemoryCache());
        imageLoader.displayImage("http://pic0.qiyipic.com/common/20151202/dcc7283bd64943cf883553fdf5b1c904.png",image);
    }
}
