package com.example.capitaladmin.dao.impl;

import android.content.Context;

import com.example.capitaladmin.dao.CapitalRecordDao;
import com.example.capitaladmin.db.MyDataBaseHelper;
import com.example.capitaladmin.entity.CapitalRecord;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午3:39:46
 * @author Administrator
 * @version 1.0
 */

public class CapitalRecordDaoImpl extends BaseDaoImpl<CapitalRecord, String> implements CapitalRecordDao {

	
	 /**
	 * @param context
	 * @param clazz
	 * @param databaseHelper
	 */
	 
	public CapitalRecordDaoImpl(Context context) {
		super(context, CapitalRecord.class, MyDataBaseHelper.getInstance(context));
	}

}
