package com.mio.volleydemo;

import java.util.HashMap;
import java.util.Map;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Window;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mio.volleydemo.Listener.MyErrorListener;
import com.mio.volleydemo.Listener.MyResponeListener;

public class StringRequestDemo extends ActionBarActivity {

	private RequestQueue mRequestQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		 //accessNetWithGET();  //get请求
		accessNetWithPost(); 	//post请求
	}
	
	
	/**
	 * get请求
	 */
	private void accessNetWithGET() {
		mRequestQueue = Volley.newRequestQueue(this);

		// 为了要发出一条HTTP请求，我们还需要创建一个StringRequest对象
		StringRequest stringRequest = new StringRequest(Method.GET,
				"http://zhidao.baidu.com/daily/view?id=899",new MyResponeListener(),new MyErrorListener());

		// 将这个StringRequest对象添加到RequestQueue里面
		mRequestQueue.add(stringRequest);

	}
	
	
	/**
	 * Post请求 指定请求方式是POST，那么我们要提交给服务器的参数又该怎么设置呢？
	 * 很遗憾，StringRequest中并没有提供设置POST参数的方法，
	 * 但是当发出POST请求的时候，Volley会尝试调用StringRequest的父类
	 * ——Request中的getParams()方法来获取POST参数，
	 * 那么解决方法自然也就有了，我们只需要在StringRequest的匿名类中重写getParams()方法，在这里设置POST参数就可以了
	 */
	private void accessNetWithPost() {
		mRequestQueue = Volley.newRequestQueue(this);
		
		StringRequest stringRequest = new StringRequest(Method.POST,
				"http://www.baidu.com/daily/view?",new MyResponeListener(),new MyErrorListener()) {
			
			//重写此方法,用来设置post参数
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", "889");
				return map;
			}
		};
		mRequestQueue.add(stringRequest);
	}
	
	
}
