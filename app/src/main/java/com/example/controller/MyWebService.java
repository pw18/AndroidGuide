package com.example.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class MyWebService extends AsyncTask<Void, Void, String> {

	ProgressDialog pDialog;
	Context context;
	MyWebServiceListener listener = null;
	String type;
	String serviceUrl;
	ArrayList<NameValuePair> params;

	public MyWebService(Context context, MyWebServiceListener listener,
			String type, String serviceUrl) {
		this.context = context;
		this.listener = listener;
		this.type = type;
		this.serviceUrl = serviceUrl;
	}

	public MyWebService(Context context, MyWebServiceListener listener,
			String type, String serviceUrl, ArrayList<NameValuePair> params) {
		this.context = context;
		this.listener = listener;
		this.type = type;
		this.serviceUrl = serviceUrl;
		this.params = params;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		pDialog = new ProgressDialog(context);
		pDialog.setTitle("My Project");
		pDialog.setMessage("Loading ...");
		pDialog.setCancelable(false);
		pDialog.setCanceledOnTouchOutside(false);
		pDialog.show();
	}

	@Override
	protected String doInBackground(Void... params) {
		String result = null;
		if (type.equals("GET")) {
			try {
				HttpResponse response = new DefaultHttpClient()
						.execute(new HttpGet(serviceUrl));
				if (response.getStatusLine().getStatusCode() == 200) {
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(response.getEntity()
									.getContent()));
					String line = null;
					result = "";
					while ((line = reader.readLine()) != null) {
						result = result + line;
					}
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (type.equals("POST")) {
			HttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(serviceUrl);
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(this.params,
						HTTP.UTF_8));
				HttpResponse response = httpClient.execute(httpPost);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					InputStream inputStream = entity.getContent();
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(inputStream));
					StringBuilder sb = new StringBuilder();
					String line = null;
					result = "";
					try {
						while ((line = reader.readLine()) != null) {
							sb.append(line + "\n");
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						try {
							inputStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					result = sb.toString();
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return result;
		}
		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		pDialog.dismiss();
		if (result != null) {
			try {
				listener.myWebServiceOK(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			listener.myWebServiceFailed();
		}
	}

}
