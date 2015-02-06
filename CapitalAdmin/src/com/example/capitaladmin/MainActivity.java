package com.example.capitaladmin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.capitaladmin.base.BaseActivity;
import com.example.capitaladmin.base.CapitalAdminApplication;
import com.example.capitaladmin.common.DataCommon;
import com.example.capitaladmin.common.GenerateId;
import com.example.capitaladmin.common.IsListNotNull;
import com.example.capitaladmin.common.StringUtil;
import com.example.capitaladmin.dao.CapitalRecordDao;
import com.example.capitaladmin.dao.impl.CapitalRecordDaoImpl;
import com.example.capitaladmin.entity.CapitalRecord;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements OnClickListener{

	private EditText costInputEdit;
	private EditText incomeEdit;
	private TextView dateText;
	private Button useCalculatorBtn;
	private Button okBtn;
	
	private List<TextView> costTypeList = new ArrayList<TextView>(16);
	private List<TextView> incomeTypeList = new ArrayList<TextView>(6);
	
	List<String> costStringList = new ArrayList<String>();
	List<String> incomeStringList = new ArrayList<String>();
	
	private int[] includeCostLayout = {R.id.first,R.id.second,R.id.third,R.id.fourth};
	private int[] includeIncomeLayout = {R.id.first_1,R.id.second_1,};
	
	public final String COST_FLAG = "COST";
	public final String INCOME_FLAG = "INCOME";
	
	public String type = null;
	
	String year;//年
	String month;//月
	String day;//日
	String week;//星期
	
	private TextView menuTextView;
	
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
		
		okBtn = (Button)findViewById(R.id.ok);
		okBtn.setOnClickListener(this);
		
		menuTextView = (TextView)findViewById(R.id.main_menu_setting_text);
		menuTextView.setOnClickListener(this);
	}
	
	public void setDateText(){
		Calendar cal = Calendar.getInstance();
		year = String.valueOf(cal.get(Calendar.YEAR));
		month = String.valueOf(cal.get(Calendar.MONTH) + 1);
		day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		week = String.valueOf(cal.get(Calendar.DAY_OF_WEEK));
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
				
				if(costInputEdit.isFocused()){
					type = COST_FLAG;
				}else{
					type = INCOME_FLAG;
				}
				
				CapitalAdminApplication.getContext().setCalculateType(type);
				
				Intent intent = new Intent(getApplicationContext() , CalculatorActivity.class);
				startActivityForResult(intent, 0);
				break;				
			case R.id.ok:
					saveCostAndIncomeData();			
				break;
			case R.id.main_menu_setting_text:
				hideInputMethod(v);
				showPopWindow(v);
				break;
			default:
				break;
			}
		}
	}
	
	public void setTextViewState(TextView view , String flag , String thirdFlag){
		String type = flag.split(":")[0];
		int position = Integer.parseInt(flag.split(":")[1]);
		boolean isChoosed = false;
		if(thirdFlag.equals("n")){//选中
			view.setTextColor(Color.BLACK);
			view.setBackgroundResource(R.drawable.button_white);
			view.setTag(flag + "y");	
			isChoosed = true;
		}else{//未选中
			view.setTextColor(Color.WHITE);
			view.setBackgroundResource(R.drawable.button_light);
			view.setTag(flag + "n");
			isChoosed = false;
		}
		
		if(INCOME_FLAG.equals(type)){
			if(!isChoosed){
				incomeStringList.remove(DataCommon.INCOME_TYPE_DATA[position]);
			}else{
				incomeStringList.add(DataCommon.INCOME_TYPE_DATA[position]);
			}
			System.out.println(incomeStringList.toString());
		}else{
			if(!isChoosed){
				costStringList.remove(DataCommon.COST_TYPE_DATA[position]);
			}else{
				costStringList.add(DataCommon.COST_TYPE_DATA[position]);
			}
			System.out.println(costStringList.toString());
		}
	}
	
	public void saveCostAndIncomeData(){
		
		CapitalRecordDao dataDao = new CapitalRecordDaoImpl(getApplicationContext());
		
		String incomeMoney = incomeEdit.getText().toString();
		String costMoney = costInputEdit.getText().toString();
		
		boolean isSaved = false;
		
		if(!StringUtil.isEmpty(incomeMoney)){
			if(!incomeMoney.equals("0")){
				if(IsListNotNull.isListNotNull(incomeStringList)){
					CapitalRecord recordData = new CapitalRecord();
					recordData.setId(GenerateId.sequenceId());
					recordData.setCount(incomeMoney);
					recordData.setType(INCOME_FLAG);			
					Date date = new Date();		
					recordData.setTime(String.valueOf(date.getTime()));
					recordData.setYear(year);
					recordData.setMonth(month);
					recordData.setWeek(week);
					recordData.setDay(day);
					recordData.setCostType(incomeStringList.toString());
					
					int result = dataDao.saveOrUpdate(recordData);
					if(result != 0){
						isSaved = true;
						Toast.makeText(getApplicationContext(), "记账成功！", Toast.LENGTH_LONG).show();
						okBtn.setText("查看账单");
					}
				}else{							
					Toast.makeText(getApplicationContext(), "请选择收入类型！", Toast.LENGTH_LONG).show();
					return;
				}
			}
		}
		
		if(!StringUtil.isEmpty(costMoney)){
			if(!costMoney.equals("0")){
				if(IsListNotNull.isListNotNull(costStringList)){
					CapitalRecord recordData = new CapitalRecord();
					recordData.setId(GenerateId.sequenceId());
					recordData.setCount(costMoney);
					recordData.setType(COST_FLAG);			
					Date date = new Date();		
					recordData.setTime(String.valueOf(date.getTime()));
					recordData.setYear(year);
					recordData.setMonth(month);
					recordData.setWeek(week);
					recordData.setDay(day);
					recordData.setCostType(costStringList.toString());
					
					int result = dataDao.saveOrUpdate(recordData);
					if(result != 0 && !isSaved){
						Toast.makeText(getApplicationContext(), "记账成功！", Toast.LENGTH_LONG).show();
						okBtn.setText("查看账单");
					}
				}else{							
					Toast.makeText(getApplicationContext(), "请选择支出类型！", Toast.LENGTH_LONG).show();
					return;
				}
			}
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 0 && data != null){
			String result = data.getExtras().getString(CalculatorActivity.RESULT);
			
			if(StringUtil.isEmpty(result)){
				return;
			}
			
			String type = CapitalAdminApplication.getContext().getCalculateType();
			if(INCOME_FLAG.equals(type)){
				incomeEdit.setText(result);
				incomeEdit.setSelection(result.length());
			}else{
				costInputEdit.setText(result);
				costInputEdit.setSelection(result.length());
			}			
		}
	}
	
}
