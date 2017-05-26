package com.tian.myimageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lxd on 2017-05-25.
 */

public class ImageLoader {

    MyImageCache myImageCache = new MemoryCache();
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void setImageCache(MyImageCache cache){
        myImageCache = cache;
    }
    public void displayImage(String imageUrl, ImageView imageView){
        Bitmap bitmap = myImageCache.get(imageUrl);
        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
            return;
        }
        submitLoadRequest(imageUrl,imageView);
    }

    private void submitLoadRequest(final String imageUrl,final ImageView imageview){
        imageview.setTag(imageUrl);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if(bitmap == null){
                    return;
                }
                if(imageview.getTag().equals(imageUrl)){
                    imageview.setImageBitmap(bitmap);
                }
                myImageCache.put(imageUrl,bitmap);
            }
        });
    }

    public Bitmap downloadImage(String imageurl){
        Bitmap bitmap = null;
        try{
            URL url = new URL(imageurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        return bitmap;
    }
}
