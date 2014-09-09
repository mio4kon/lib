package com.mio.volleydemo;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.mio.volleydemo.Listener.MyErrorListener;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

/**
 * 建议使用ImageLoader:不仅可以帮我们对图片进行缓存，还可以过滤掉重复的链接，避免重复发送请求
 * @author mio
 *
 */
public class ImageRequestDemo extends ActionBarActivity {

	String url="http://a.hiphotos.baidu.com/image/pic/item/95eef01f3a292df5802eac60be315c6035a873d1.jpg";
	private ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.iv);
		Log.d("ImageRequestDemo", "oncreate");
		getImageData();
		
	}

	private void getImageData() {
		RequestQueue mRequestQueue = Volley.newRequestQueue(this);
		ImageRequest request = new ImageRequest(url, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap response) {
				iv.setImageBitmap(response);
			}
		}, 0, 0, Config.RGB_565, new MyErrorListener());
		mRequestQueue.add(request);
		
		
	}
	
}
