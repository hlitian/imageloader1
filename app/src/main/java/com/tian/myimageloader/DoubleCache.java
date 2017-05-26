package com.tian.myimageloader;

import android.graphics.Bitmap;

/**
 * Created by lxd on 2017-05-25.
 */

public class DoubleCache implements MyImageCache {

    MemoryCache memoryCache = new MemoryCache();
    DiskCache diskCache = new DiskCache();

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = memoryCache.get(url);
        if(bitmap == null){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        memoryCache.put(url,bitmap);
        diskCache.put(url,bitmap);
    }
}
