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
	}
	
	public void bindEvent(){
		costInputEdit = (EditText)findViewById(R.id.cost_input_edit);
		incomeEdit = (EditText)findViewById(R.id.income_input_edit);
		dateText = (TextView)findViewById(R.id.date_text);
	}
	
	public void setDateText(){
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.WEEK_OF_MONTH);
	}
}
