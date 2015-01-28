package com.example.capitaladmin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import com.example.capitaladmin.base.BaseActivity;
import com.example.capitaladmin.common.DataCommon;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener{

	private EditText costInputEdit;
	private EditText incomeEdit;
	private TextView dateText;
	private Button useCalculatorBtn;
	
	private List<TextView> costTypeList = new ArrayList<TextView>(16);
	private List<TextView> incomeTypeList = new ArrayList<TextView>(6);
	
	private int[] includeCostLayout = {R.id.first,R.id.second,R.id.third,R.id.fourth};
	private int[] includeIncomeLayout = {R.id.first_1,R.id.second_1,};
	
	public final String COST_FLAG = "COST";
	public final String INCOME_FLAG = "INCOME";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bindEvent();
		setDateText();
		setTextViewData();
	}
	
	public void bindEvent(){
		costInputEdit = (EditText)findViewById(R.id.cost_input_edit);
		incomeEdit = (EditText)findViewById(R.id.income_input_edit);
		dateText = (TextView)findViewById(R.id.date_text);
		useCalculatorBtn = (Button)findViewById(R.id.use_caculator);
		useCalculatorBtn.setOnClickListener(this);
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
	
	public void setTextViewData(){
		for(int i = 0 ; i < includeCostLayout.length ; i++){
			LinearLayout currentLayout = (LinearLayout)findViewById(includeCostLayout[i]);
			TextView first = (TextView)currentLayout.findViewById(R.id.first_text);
			TextView second = (TextView)currentLayout.findViewById(R.id.second_text);
			TextView third = (TextView)currentLayout.findViewById(R.id.third_text);
			costTypeList.add(first);
			costTypeList.add(second);
			costTypeList.add(third);
		}
		
		int typeCount = DataCommon.COSTTYPE.length;
		
		for(int m = 0; m < costTypeList.size() ; m++){
			if(m >= typeCount){
				costTypeList.remove(m);
			}else{
				costTypeList.get(m).setTag(COST_FLAG + ":" + m + ":" + "n");
				costTypeList.get(m).setVisibility(View.VISIBLE);
				costTypeList.get(m).setText(DataCommon.COSTTYPE[m]);
				costTypeList.get(m).setOnClickListener(this);
			}
		}
		
		for(int j = 0 ; j < includeIncomeLayout.length ; j++){
			LinearLayout currentIncomeLayout = (LinearLayout)findViewById(includeIncomeLayout[j]);
			TextView first_1 = (TextView)currentIncomeLayout.findViewById(R.id.first_text);
			TextView second_2 = (TextView)currentIncomeLayout.findViewById(R.id.second_text);
			TextView third_3 = (TextView)currentIncomeLayout.findViewById(R.id.third_text);
			incomeTypeList.add(first_1);
			incomeTypeList.add(second_2);
			incomeTypeList.add(third_3);
		}
		
		int incomeTypeCount = DataCommon.INCOMTYPE.length;
		
		for(int n = 0; n < incomeTypeList.size() ; n++){
			if(n >= incomeTypeCount){
				incomeTypeList.remove(n);
			}else{
				incomeTypeList.get(n).setTag(INCOME_FLAG + ":" + n + ":" + "n");
				incomeTypeList.get(n).setVisibility(View.VISIBLE);
				incomeTypeList.get(n).setText(DataCommon.INCOMTYPE[n]);
				incomeTypeList.get(n).setOnClickListener(this);
			}
		}
	}

	@Override
	public void onClick(View v) {
		String tag = (String)v.getTag();
		if(tag != null && tag.contains(":")){			
			String firstFlag = tag.split(":")[0];
			String secondFlag = tag.split(":")[1];
			String thirdFlag = tag.split(":")[2];
			String mixFlag = firstFlag + ":" + secondFlag + ":";
			Integer index = Integer.parseInt(secondFlag);
			if(firstFlag.equals(COST_FLAG)){
				for(int i = 0 ; i < costTypeList.size() ; i++){
					if(i == index){
						setTextViewState(costTypeList.get(i), mixFlag, thirdFlag);		
					}
				}
			}else{
				for(int j = 0 ; j < incomeTypeList.size() ; j++){
					if(j == index){
						setTextViewState(incomeTypeList.get(j), mixFlag, thirdFlag);		
					}
				}
			}
		}else{
			switch (v.getId()) {
			case R.id.use_caculator:
				Intent intent = new Intent(getApplicationContext() , CalculatorActivity.class);
				startActivity(intent);
				break;

			default:
				break;
			}
		}
	}
	
	public void setTextViewState(TextView view , String flag , String thirdFlag){
		if(thirdFlag.equals("n")){
			view.setTextColor(Color.BLACK);
			view.setBackgroundResource(R.drawable.button_white);
			view.setTag(flag + "y");
		}else{
			view.setTextColor(Color.WHITE);
			view.setBackgroundResource(R.drawable.button_light);
			view.setTag(flag + "n");
		}	
	}
}
