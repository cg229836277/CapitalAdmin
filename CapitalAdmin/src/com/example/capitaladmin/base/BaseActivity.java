package com.example.capitaladmin.base;


import java.io.IOException;

import com.example.capitaladmin.view.MyProgressDialog;
import com.example.capitaladmin.view.MyToastDialog;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Window;

public class BaseActivity extends Activity {

	public MyProgressDialog progressDialog;
	public MyToastDialog toastDialog;
	public static DisplayMetrics screenMetric; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initScreenSize();
		
		progressDialog = MyProgressDialog.createDialog(BaseActivity.this);
		toastDialog = new MyToastDialog(BaseActivity.this);
	}
	
	/**
	 * 设置屏幕的尺寸
	 * 
	 * @author chengang
	 * @date 2014-10-29 上午9:42:26
	 */
	public void initScreenSize(){
		screenMetric = new DisplayMetrics();   
        getWindowManager().getDefaultDisplay().getMetrics(screenMetric);
        if(screenMetric != null){
        	CapitalAdminApplication.getContext().setScreenSize(screenMetric);  
        }
	}
	
	/**
	 * 点击页面顶部的返回按钮
	 * 
	 * @author Administrator
	 * @date 2014-12-3 上午10:43:43
	 */
	public void backImageClicked(){
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
