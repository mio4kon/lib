package com.mio.volleydemo.cache;

import android.R.integer;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;

/**
 * 图片缓存:使用Lrucache
 * @author mio
 *
 */
public class BitmapCache implements ImageCache {
	
	private LruCache<String, Bitmap> mCache;
	private int CacheSize=10*1024*1024; //10m
	
	public BitmapCache() {
		
		int maxSize=CacheSize;
		//need override sizeOf to return bigmap size
		mCache=new LruCache<String, Bitmap>(maxSize){

			@Override
			protected int sizeOf(String key, Bitmap bitmap) {
				return bitmap.getRowBytes()*bitmap.getHeight();
			}

			
		};
		
		
	}

	@Override
	public Bitmap getBitmap(String url) {
		return mCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		mCache.put(url, bitmap);
	}

}
