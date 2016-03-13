package com.example.controller;

public interface MyWebServiceListener {

	void myWebServiceOK(String result) throws Exception;
	void myWebServiceFailed();
	
}
