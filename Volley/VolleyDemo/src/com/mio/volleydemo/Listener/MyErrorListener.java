package com.mio.volleydemo.Listener;

import android.util.Log;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
/**
 * 请求失败回调
 * @author mio
 *
 */
public class MyErrorListener implements ErrorListener {
	
	@Override
	public void onErrorResponse(VolleyError error) {
		Log.e("TAG", error.getMessage(), error);
	}
}
