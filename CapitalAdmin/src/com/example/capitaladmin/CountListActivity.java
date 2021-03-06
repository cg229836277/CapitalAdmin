package com.example.capitaladmin;

import com.example.capitaladmin.common.DataCommon;
import com.example.capitaladmin.common.SpinnerAdapterFactory;
import com.example.capitaladmin.view.CustomListView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class CountListActivity extends Activity {

	private Spinner typeSpinner;
	private SpinnerAdapter adapter;
	private Button detailBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count_list);
		
		bindEvent();
	}
	
	public void bindEvent(){
		typeSpinner = (Spinner)findViewById(R.id.count_type_spinner);
		adapter = SpinnerAdapterFactory.getAdapter(DataCommon.SEARCH_TYPE);
		typeSpinner.setAdapter(adapter);
		typeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				
			}
			
		});
		
		detailBtn = (Button)findViewById(R.id.scan_detail_list);
		detailBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(getApplicationContext(), CountListDetailActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public void searchTypeData(){
		
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() != 0){
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
