package com.mio.volleydemo;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.XmlRequest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Window;

public class XmlRequestDemo extends ActionBarActivity {
	private String url="http://flash.weather.com.cn/wmaps/xml/china.xml";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
		getXmlData();
	}

	private void getXmlData() {
		RequestQueue mRequestQueue = Volley.newRequestQueue(this);
		XmlRequest xmlRequest = new XmlRequest(url, new Listener<XmlPullParser>() {

			@Override
			public void onResponse(XmlPullParser response) {
				//response是包含XML的解析器了.直接用它解析
				//对XML如何处理看需求
				 try {  
	                    int eventType = response.getEventType();  
	                    while (eventType != XmlPullParser.END_DOCUMENT) {  
	                        switch (eventType) {  
	                        case XmlPullParser.START_TAG:  
	                            String nodeName = response.getName();  
	                            if ("city".equals(nodeName)) {  
	                                String pName = response.getAttributeValue(0);  
	                                Log.d("TAG", "pName is " + pName);  
	                            }  
	                            break;  
	                        }  
	                        eventType = response.next();  
	                    }  
	                } catch (XmlPullParserException e) {  
	                    e.printStackTrace();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
			
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				 Log.e("TAG", error.getMessage(), error);  
			}
		});
		mRequestQueue.add(xmlRequest); 
		
	}
}
