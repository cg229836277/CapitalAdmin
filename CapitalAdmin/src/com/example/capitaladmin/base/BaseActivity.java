package com.example.capitaladmin.base;


import java.io.IOException;

import com.example.capitaladmin.CountListActivity;
import com.example.capitaladmin.R;
import com.example.capitaladmin.view.MyProgressDialog;
import com.example.capitaladmin.view.MyToastDialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;

public class BaseActivity extends Activity {

	public MyProgressDialog progressDialog;
	public MyToastDialog toastDialog;
	public static DisplayMetrics screenMetric; 
	public PopupWindow popWindow;
	
	public Button scanLocalSheetBtn;
	public Button scanRemoteSheetBtn;
	public Button shareSheetBtn;
	public Button settingBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		initScreenSize();
		
		initPopWindow();
		
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
	
	public void initPopWindow(){
		View popupWindow_view = getLayoutInflater().inflate(R.layout.activity_popwindow_right, null,false);
	    // 创建PopupWindow实例,200,LayoutParams.MATCH_PARENT分别是宽度和高度
		popWindow = new PopupWindow(popupWindow_view, 200, LayoutParams.MATCH_PARENT, true);
		popWindow.setOutsideTouchable(true);
		
		scanLocalSheetBtn = (Button)popupWindow_view.findViewById(R.id.scan_local_count_sheet);
		scanRemoteSheetBtn = (Button)popupWindow_view.findViewById(R.id.scan_remote_count_sheet);
		shareSheetBtn = (Button)popupWindow_view.findViewById(R.id.shareSheet);
		settingBtn = (Button)popupWindow_view.findViewById(R.id.setting);
		
		setViewEvent();
		
		// 点击其他地方消失
		popupWindow_view.setOnTouchListener(new OnTouchListener() {
		  @Override
		  public boolean onTouch(View v, MotionEvent event) {
		    if (popWindow != null && popWindow.isShowing()) {
		      popWindow.dismiss();
		    }
		    return false;
		  }
		});
	}

	public void showPopWindow(View v){
		if(popWindow != null){
			if(!popWindow.isShowing()){
				popWindow.showAtLocation(v, Gravity.RIGHT, 0, 0);
			}
		}
	}
	
	public void setViewEvent(){
		scanLocalSheetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BaseActivity.this , CountListActivity.class);
				startActivity(intent);
			}
		});
		scanRemoteSheetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BaseActivity.this , CountListActivity.class);
				startActivity(intent);
			}
		});
		shareSheetBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});		
		settingBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
			}
		});
	}
	
	public void hideInputMethod(View v){
		InputMethodManager imm = (InputMethodManager)(getApplicationContext()).getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
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
