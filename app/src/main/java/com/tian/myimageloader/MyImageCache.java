package com.tian.myimageloader;

import android.graphics.Bitmap;

/**
 * Created by lxd on 2017-05-25.
 */

public interface MyImageCache {

    Bitmap get(String url);
    void put(String url,Bitmap bitmap);

}

