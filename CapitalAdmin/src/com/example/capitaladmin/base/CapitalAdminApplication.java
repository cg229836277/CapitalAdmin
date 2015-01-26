package com.example.capitaladmin.base;

import android.app.Application;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午2:03:13
 * @author Administrator
 * @version 1.0
 */

public class CapitalAdminApplication extends Application {
	public static CapitalAdminApplication appContext;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		appContext = this;
	}
	
	public static CapitalAdminApplication getContext(){
		return appContext;
	}
}
