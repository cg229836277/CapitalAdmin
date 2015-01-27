package com.example.capitaladmin;

import java.util.Calendar;

import com.example.capitaladmin.base.BaseActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

	private EditText costInputEdit;
	private EditText incomeEdit;
	private TextView dateText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bindEvent();
		setDateText();
	}
	
	public void bindEvent(){
		costInputEdit = (EditText)findViewById(R.id.cost_input_edit);
		incomeEdit = (EditText)findViewById(R.id.income_input_edit);
		dateText = (TextView)findViewById(R.id.date_text);
	}
	
	public void setDateText(){
		Calendar cal = Calendar.getInstance();
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		String day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		String week = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));
		String weekString = "星期";
		
        if("1".equals(week)){  
        	weekString +="天";  
        }else if("2".equals(week)){  
        	weekString +="一";  
        }else if("3".equals(week)){  
        	weekString +="二";  
        }else if("4".equals(week)){  
        	weekString +="三";  
        }else if("5".equals(week)){  
        	weekString +="四";  
        }else if("6".equals(week)){  
        	weekString +="五";  
        }else if("7".equals(week)){  
        	weekString +="六";  
        }  
		
		String date = "今天是 " + year + " 年 " + month + " 月 " + day + " 日" + "\n" + weekString;
		dateText.setText(date);
	}
}
