package com.mio.volleydemo.Listener;

import org.json.JSONObject;

import android.util.Log;

import com.android.volley.Response.Listener;
/**
 * 请求成功回调
 * @author mio
 * @param <T>
 *
 */
public class MyResponeListener<T> implements Listener<T> {
	@Override
	public void onResponse(T response) {
		Log.d("TAG", response.toString());
	}
}
