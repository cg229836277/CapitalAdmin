package com.example.capitaladmin;

import com.example.capitaladmin.base.BaseActivity;
import com.example.capitaladmin.common.StringUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CalculatorActivity extends BaseActivity implements OnClickListener{

	//数字以及操作按钮
	private final int[] buttonNumberIds = {R.id.one , R.id.two , R.id.three , R.id.four};
	//按钮所在的父视图
	private final int[] parentViewIds = {R.id.first , R.id.second , R.id.third , R.id.fourth};
	//之外的三个按钮
	private final int[] buttonExtraIds = {R.id.delete , R.id.ok , R.id.cancle};
	//操作符号
	private final String[] operateSign = {"7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
	
	private Button deleteBtn;
	private Button okBtn;
	private Button cancleBtn;
	private EditText inputEditText;
	
	private final String OPERATE_ADD = "+";
	private final String OPERATE_REDUCE = "-";
	private final String OPERATE_MULTIPLY = "*";
	private final String OPERATE_SEPERATE = "/";
	private final String OPERATE_POINT = ".";
	private final String OPERATE_EQUAL = "=";
	private final String OPERATE_CANCEL = "C";
	
	private String operateType = null;
	
	private final String[] unNumberOperate = {"/","*","-",".","=","+","C"};
	private final String[] numberOperate = {"0","1","2","3","4","5","6","7","8","9"};
	
	private String operateNumber = null;//操作数
	private String operatedNumber = null;//被操作数
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		bindEvent();
	}

	public void bindEvent(){
		int index = 0;
		for(int i = 0 ; i < parentViewIds.length ; i++){
			LinearLayout parentView = (LinearLayout)findViewById(parentViewIds[i]);
			for(int j = 0 ; j < buttonNumberIds.length ; j++){
				index = 4 * i + j;
				Button currentButton = (Button)parentView.findViewById(buttonNumberIds[j]);
				currentButton.setText(operateSign[index]);
				currentButton.setOnClickListener(this);
				currentButton.setTag(operateSign[index]);		
				currentButton.setFocusable(false);
			}
		}
		
		deleteBtn = (Button)findViewById(buttonExtraIds[0]);
		okBtn = (Button)findViewById(buttonExtraIds[1]);
		cancleBtn = (Button)findViewById(buttonExtraIds[2]);
		deleteBtn.setOnClickListener(this);
		okBtn.setOnClickListener(this);
		cancleBtn.setOnClickListener(this);
		
		inputEditText = (EditText)findViewById(R.id.number_input_edit);
	}
	
	@Override
	public void onClick(View v) {
		String tag = (String)v.getTag();
		if(tag != null){
			for(int i = 0 ; i < unNumberOperate.length ; i++){
				if(unNumberOperate[i].equals(tag)){
					dealOperate(tag);
					break;
				}
			}
			
			for(int j = 0 ; j < numberOperate.length ; j++){
				if(numberOperate[j].equals(tag)){
					operateNumberClicked(tag);
					break;
				}
			}
		}
	}
	
	public void dealOperate(String operateSign){
		switch (operateSign) {
		case OPERATE_ADD:			
			operateType = OPERATE_ADD;	
			addTwoNumbers();
			break;
		case OPERATE_REDUCE:
			operateType = OPERATE_REDUCE;	
			reduceTwoNumbers();
			break;
		case OPERATE_MULTIPLY:
			operateType = OPERATE_MULTIPLY;	
			multiplyTwoNumbers();
			break;
		case OPERATE_SEPERATE:
			
			break;
		case OPERATE_POINT:
			if(!StringUtil.isEmpty(operateNumber) && !operateNumber.contains(".")){
				operateNumber += ".";
			}
			break;
		case OPERATE_EQUAL:
			if(!StringUtil.isEmpty(operateType) && operateType.equals(OPERATE_ADD)){
				addTwoNumbers();
			}else if(!StringUtil.isEmpty(operateType) && operateType.equals(OPERATE_REDUCE)){
				reduceTwoNumbers();
			}else if(!StringUtil.isEmpty(operateType) && operateType.equals(OPERATE_MULTIPLY)){
				multiplyTwoNumbers();
			}
			operateType = null;		
			break;
		case OPERATE_CANCEL:
			
			break;

		default:
			break;
		}
	}
	
	/**
	 * 两个数相加
	 * 
	 * @author Administrator
	 * @date 2015-1-28 下午3:20:02
	 */
	public void addTwoNumbers(){
		operateNumber = inputEditText.getText().toString();
		if(StringUtil.isEmpty(operatedNumber)){
			return;
		}
		int addedNumber = Integer.valueOf(operatedNumber);
		int addNumber = Integer.valueOf(operateNumber);
		int addition = addedNumber + addNumber;
		String addNumberString = String.valueOf(addition);
		inputEditText.setText(addNumberString);
		operateNumber = addNumberString;		
	}
	
	/**
	 * 两个数相减
	 * 
	 * @author Administrator
	 * @date 2015-1-28 下午3:20:02
	 */
	public void reduceTwoNumbers(){
		operateNumber = inputEditText.getText().toString();
		if(StringUtil.isEmpty(operatedNumber)){
			return;
		}
		int reducedNumber = Integer.valueOf(operatedNumber);
		int reduceNumber = Integer.valueOf(operateNumber);
		int reducetion = reducedNumber - reduceNumber;
		String reduceNumberString = String.valueOf(reducetion);
		inputEditText.setText(reduceNumberString);
		operateNumber = reduceNumberString;		
	}
	
	/**
	 * 两个数相乘
	 * 
	 * @author Administrator
	 * @date 2015-1-28 下午3:20:02
	 */
	public void multiplyTwoNumbers(){
		operateNumber = inputEditText.getText().toString();
		if(StringUtil.isEmpty(operatedNumber)){
			return;
		}
		int multiedNumber = Integer.valueOf(operatedNumber);
		int multiNumber = Integer.valueOf(operateNumber);
		int multion = multiedNumber * multiNumber;
		String multiNumberString = String.valueOf(multion);
		inputEditText.setText(multiNumberString);
		operateNumber = multiNumberString;		
	}
	
	public void operateNumberClicked(String number){
		
		if(!StringUtil.isEmpty(operateType)){
			operatedNumber = inputEditText.getText().toString();
			operateType = null;
			inputEditText.setText("");
		}
		
		String inputNumber = inputEditText.getText().toString();
		if(StringUtil.isEmpty(inputNumber) && !StringUtil.isEmpty(number) && number.equals("0")){
			inputEditText.setText(inputNumber);
			return;
		}
		//如果用户一开始一直输入“0”，则操作数是0
		if(!StringUtil.isEmpty(inputNumber) && inputNumber.equals("0") && inputNumber.equals(number)){
			return;
		}
		
		inputNumber += number;		
		inputEditText.setText(inputNumber);		
	}
}
