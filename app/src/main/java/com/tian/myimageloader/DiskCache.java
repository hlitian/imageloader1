package com.tian.myimageloader;

import android.graphics.Bitmap;

/**
 * Created by lxd on 2017-05-25.
 */

public class DiskCache implements MyImageCache {
    @Override
    public Bitmap get(String url) {
        return null;
    }

    @Override
    public void put(String url, Bitmap bitmap) {

    }
}
