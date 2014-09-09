package com.mio.volleydemo;

import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mio.volleydemo.Listener.MyErrorListener;
import com.mio.volleydemo.Listener.MyResponeListener;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

public class JsonRequestDemo extends ActionBarActivity {

	private RequestQueue mRequestQueue;
	private String url = "http://www.weather.com.cn/data/cityinfo/101010100.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		getJsonData();

	}

	private void getJsonData() {
		mRequestQueue = Volley.newRequestQueue(this);
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET, url, null,
				new MyResponeListener<JSONObject>(), new MyErrorListener());
		mRequestQueue.add(jsonObjectRequest);  
	}
}
