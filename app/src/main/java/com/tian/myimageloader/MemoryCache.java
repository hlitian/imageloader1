package com.tian.myimageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by lxd on 2017-05-25.
 */

public class MemoryCache implements MyImageCache {

    private LruCache<String,Bitmap> mMemeryCache;

    public MemoryCache(){
        initImageCache();
    }
    private void initImageCache(){
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = maxMemory/4;
        mMemeryCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes()*bitmap.getHeight()/1024;
            }
        };
    }

    @Override
    public Bitmap get(String url) {
        return mMemeryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemeryCache.put(url,bitmap);
    }
}
