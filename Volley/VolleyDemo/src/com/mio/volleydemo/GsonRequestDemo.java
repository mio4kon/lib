package com.mio.volleydemo;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.GsonRequest;
import com.android.volley.toolbox.Volley;
import com.mio.volleydemo.javabean.Weather;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class GsonRequestDemo extends ActionBarActivity {
	
	private String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getGsonBean();
	}

	private void getGsonBean() {
		RequestQueue mRequestQueue = Volley.newRequestQueue(this);
		
		GsonRequest<Weather> gsonRequest = new GsonRequest<Weather>(url, Weather.class, new Listener<Weather>() {

			@Override
			public void onResponse(Weather response) {
				String city = response.getWeatherinfo().getCity();
				Log.e("city", city);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Log.e("TAG", error.getMessage(), error); 
			}
		});
		
		mRequestQueue.add(gsonRequest);
	}
}
