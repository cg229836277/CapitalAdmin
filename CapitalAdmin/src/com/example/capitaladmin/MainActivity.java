package com.example.capitaladmin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.example.capitaladmin.base.BaseActivity;
import com.example.capitaladmin.base.CapitalAdminApplication;
import com.example.capitaladmin.common.DataCommon;
import com.example.capitaladmin.common.GenerateId;
import com.example.capitaladmin.common.IsListNotNull;
import com.example.capitaladmin.common.SpinnerAdapterFactory;
import com.example.capitaladmin.common.StringUtil;
import com.example.capitaladmin.dao.CapitalRecordDao;
import com.example.capitaladmin.dao.impl.CapitalRecordDaoImpl;
import com.example.capitaladmin.entity.CapitalRecord;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener{

	private EditText costInputEdit;
	private EditText incomeEdit;
	private TextView dateText;
	private Button useCalculatorBtn;
	private Button okBtn;
	private Spinner parentTypeSpinner;
	private Spinner costTypeSpinner;
	private Button addCostItemButton;
	private LinearLayout costItemContainer;	
	private SpinnerAdapter costAdapter;
	private SpinnerAdapter parentTypeAdapter;
		
	List<CapitalRecord> recordDataList = new ArrayList<CapitalRecord>();
	
	public final String COST_FLAG = "COST";
	public final String INCOME_FLAG = "INCOME";
	
	private LayoutInflater inflater;
	
	public String type = null;
	
	String year;//年
	String month;//月
	String day;//日
	String week;//星期
	
	private TextView menuTextView;
	
	private String costType = null;
	private String costCount = null;
	
	private String incomeType = null;
	private String incomeCount = null;
	
	private int costIndex = 0;
	private int incomeIndex = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		inflater = LayoutInflater.from(getApplicationContext());
		
		bindEvent();
		setDateText();
	}
	
	public void bindEvent(){
		costInputEdit = (EditText)findViewById(R.id.cost_input_edit);
		dateText = (TextView)findViewById(R.id.date_text);
		useCalculatorBtn = (Button)findViewById(R.id.use_caculator);
		useCalculatorBtn.setOnClickListener(this);
		
		okBtn = (Button)findViewById(R.id.ok);
		okBtn.setOnClickListener(this);
		
		addCostItemButton = (Button)findViewById(R.id.add_cost_item_button);
		addCostItemButton.setOnClickListener(this);
		
		menuTextView = (TextView)findViewById(R.id.main_menu_setting_text);
		menuTextView.setOnClickListener(this);
		
		costItemContainer = (LinearLayout)findViewById(R.id.cost_item_container);
		
		costTypeSpinner = (Spinner)findViewById(R.id.cost_item_name_spinner);
		parentTypeSpinner = (Spinner)findViewById(R.id.parent_type_spinner);

		costAdapter = SpinnerAdapterFactory.getAdapter(DataCommon.COSTTYPE);
		parentTypeAdapter = SpinnerAdapterFactory.getAdapter(DataCommon.PARENT_TYPE);
		parentTypeSpinner.setAdapter(parentTypeAdapter);
		costTypeSpinner.setAdapter(costAdapter);		
		costTypeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				if(arg2 == 0){
					costType = null;
				}else{
					costType = DataCommon.COSTTYPE[arg2];
					costIndex = arg2 - 1;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
		
		parentTypeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				if(arg2 == 0){
					costType = null;
				}else{
					costType = DataCommon.COSTTYPE[arg2];
					costIndex = arg2 - 1;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
		});
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
	
	@Override
	public void onClick(View v) {
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
		case R.id.add_cost_item_button:
			String costCount = costInputEdit.getText().toString();
			addCostItemView(costType , costCount);
			break;
		default:
			break;
		}
	}
	
	public void saveCostAndIncomeData(){
		
		CapitalRecordDao dataDao = new CapitalRecordDaoImpl(getApplicationContext());
		if(IsListNotNull.isListNotNull(recordDataList)){	
			int flag = dataDao.save(recordDataList);
			if(flag == 1){
				toastDialog.show("保存成功！");
				costItemContainer.removeAllViews();
				if(recordDataList.size() > 0){
					recordDataList.clear();
				}
			}
		}
	}
	
	public void addCostItemView(String nameType , String countNumber){
		
		if(StringUtil.isEmpty(nameType)){
			toastDialog.show("请先选择支出类型");
			return;
		}
		
		if(StringUtil.isEmpty(countNumber)){
			toastDialog.show("请填写支出金额");
			return;
		}
		
		generateData(nameType, countNumber, COST_FLAG);
	}
	
	public void addIncomeItemView(String nameType , String countNumber){
		if(StringUtil.isEmpty(nameType)){
			toastDialog.show("请先选择收入类型");
			return;
		}
		
		if(StringUtil.isEmpty(countNumber)){
			toastDialog.show("请填写收入金额");
			return;
		}
		
		generateData(nameType, countNumber, INCOME_FLAG);
	}
	
	public void generateData(String type , String countNumber , final String flag){
		CapitalRecord recordData = new CapitalRecord();
		recordData.setId(GenerateId.sequenceId());
		recordData.setCount(countNumber);
		recordData.setType(flag);			
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = format.format(new Date());
		recordData.setTime(time);
		recordData.setYear(year);
		recordData.setMonth(month);
		recordData.setWeek(week);
		recordData.setDay(day);			
		
		final View childView = inflater.inflate(R.layout.cost_income_type_item, null);		
		TextView nameView = (TextView)childView.findViewById(R.id.item_name);
		nameView.setText(type);
		TextView countNumberView = (TextView)childView.findViewById(R.id.count_number_text);
		countNumberView.setText(countNumber);
		Button deleteItemBtn = (Button)childView.findViewById(R.id.delete_item_button);
		deleteItemBtn.setTag(flag);
		deleteItemBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				View parentView = (View)arg0.getParent();
				CapitalRecord deleteRecordData = (CapitalRecord)parentView.getTag();
				recordDataList.remove(deleteRecordData);
				
				String flag = (String)arg0.getTag();
				costItemContainer.removeView(parentView);
			}
		});
		
		if(INCOME_FLAG.equals(flag)){		
			recordData.setCostType(DataCommon.INCOME_TYPE_DATA[incomeIndex]);	
		}else{			
			recordData.setCostType(DataCommon.COST_TYPE_DATA[costIndex]);	
		}
		costItemContainer.addView(childView, -1);
		recordDataList.add(recordData);
		childView.setTag(recordData);
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
