package com.example.capitaladmin.view;

import com.example.capitaladmin.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-2-3 上午9:41:50
 * @author Administrator
 * @version 1.0
 */

public class MainMenuTitleLayout extends RelativeLayout {
	 
	private TextView settingText;
	public SettingTextClickedListenner mSettingTextClickedListenner;
	
	public MainMenuTitleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}
	
	public void initView(Context context){
		LayoutInflater flater = LayoutInflater.from(context);
		View titleView = flater.inflate(R.layout.activity_main_title_header, null);
		if(titleView != null){
			settingText = (TextView)findViewById(R.id.main_menu_setting_text);
			settingText.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					settingTextClicked();
				}
			});
		}
	}
	
	public interface SettingTextClickedListenner{
		public void settingTextClicked();
	}

	public void setSettingTextClickListenner(SettingTextClickedListenner settingTextClickedListenner){
		this.mSettingTextClickedListenner = settingTextClickedListenner;
	}
	
	private void settingTextClicked(){
		if(mSettingTextClickedListenner != null){
			mSettingTextClickedListenner.settingTextClicked();
		}
	}
}
