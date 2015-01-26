package com.example.capitaladmin.base;

import android.app.Application;
import android.util.DisplayMetrics;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午2:03:13
 * @author Administrator
 * @version 1.0
 */

public class CapitalAdminApplication extends Application {
	
	public static CapitalAdminApplication appContext;
	public DisplayMetrics screenSize;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		appContext = this;
	}
	
	public static CapitalAdminApplication getContext(){
		return appContext;
	}
	
	/**
	 * 获取屏幕尺寸
	 * 
	 * @author chengang
	 * @date 2014-10-29 上午9:26:14
	 * @return
	 */
	public DisplayMetrics getScreenSize() {
		return screenSize;
	}
	
	/**
	 * 设置屏幕尺寸
	 * 
	 * @author chengang
	 * @date 2014-10-29 上午9:26:29
	 * @param screenSize
	 */
	public void setScreenSize(DisplayMetrics screenSize) {
		this.screenSize = screenSize;
	}
}
