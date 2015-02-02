package com.example.capitaladmin.common;

import com.example.capitaladmin.R;
import com.example.capitaladmin.base.CapitalAdminApplication;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-2-2 下午5:21:16
 * @author Administrator
 * @version 1.0
 */

public class SpinnerAdapterFactory {
	
	private static Context context = CapitalAdminApplication.getContext();
	public static SpinnerAdapter getAdapter(Object[] items){ 
		ArrayAdapter<Object> adapter = new ArrayAdapter<Object>(context, R.layout.spinner_item_layout, R.id.spinner_item_text, items);
		return adapter;
	}

}
