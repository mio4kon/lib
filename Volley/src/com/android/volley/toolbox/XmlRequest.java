package com.android.volley.toolbox;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;

/**
 * 请求返回信息是Xml
 * 参考StringRequest源码
 * @author mio
 *
 */
public class XmlRequest extends Request<XmlPullParser> {

	private Listener<XmlPullParser> mListener;

	public XmlRequest(int method, String url, Listener<XmlPullParser> listener,
			ErrorListener errorListener) {
		super(method, url, errorListener);
		mListener = listener;
	}

	public XmlRequest(String url, Listener<XmlPullParser> listener, ErrorListener errorListener) {  
        this(Method.GET, url, listener, errorListener);  
    }  

	@Override
	protected Response<XmlPullParser> parseNetworkResponse(
			NetworkResponse response) {
		 try {  
			 	//得到xml的字符串
	            String xmlString = new String(response.data,  
	                    HttpHeaderParser.parseCharset(response.headers));  
	            
	            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();  
	            XmlPullParser xmlPullParser = factory.newPullParser();  
	            //给pull解析器一个输入流数据
	            xmlPullParser.setInput(new StringReader(xmlString));  
	            return Response.success(xmlPullParser, HttpHeaderParser.parseCacheHeaders(response));  
	        } catch (UnsupportedEncodingException e) {  
	            return Response.error(new ParseError(e));  
	        } catch (XmlPullParserException e) {  
	            return Response.error(new ParseError(e));  
	        }  
	}

	@Override
	protected void deliverResponse(XmlPullParser response) {
		mListener.onResponse(response);
	}

}