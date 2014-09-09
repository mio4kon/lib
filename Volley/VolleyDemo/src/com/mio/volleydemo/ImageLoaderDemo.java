package com.mio.volleydemo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;
import com.mio.volleydemo.cache.BitmapCache;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.widget.ImageView;

/**
 * 加载图片建议用ImageLoader而不是ImageRequest
 * @author mio
 *
 */
public class ImageLoaderDemo extends ActionBarActivity {

	private ImageView iv;
	private RequestQueue mRequestQueue;
	private String url="http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		iv = (ImageView) findViewById(R.id.iv);
		getImageData();
	}

	/**
	 * 使用方法与之前有点区别
	 */
	private void getImageData() {
		//1. 与之前一样
		mRequestQueue = Volley.newRequestQueue(this);
		//2.创建一个imageLoader,第二个参数用我们自己所写的BitmapCache(LruCache)
		ImageLoader mImageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
		
		//3.得到一个ImageListener
		ImageListener mListener = ImageLoader.getImageListener(iv, R.drawable.ic_launcher, R.drawable.ic_launcher);
		
		//4.最后调用imageLoader的get方法来加载图片
		mImageLoader.get(url, mListener);
		
	}
}
