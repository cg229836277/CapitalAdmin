package com.example.capitaladmin.db;

import com.example.capitaladmin.common.DataPath;
import com.example.capitaladmin.entity.CapitalRecord;
import com.example.capitaladmin.entity.TableEntity;
import com.j256.ormlite.support.ConnectionSource;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午2:25:50
 * @author Administrator
 * @version 1.0
 */

public class MyDataBaseHelper extends DataBaseHelper{

	private static MyDataBaseHelper helper;
	private static String DATA_BASE_NAME = "record.db";
	private static int APP_VERSION = 1;
	
	 /**
	 * @param context
	 */
	 
	public MyDataBaseHelper(Context context) {
		super(context , DATA_BASE_NAME , APP_VERSION);
	}
	
	public static MyDataBaseHelper getInstance(Context context){
		if (helper ==null||!helper.isOpen()) {
			helper = new MyDataBaseHelper(context);
		}
		return helper;		
	}

	@Override
	public String getDataBaseFilePath() {
		return DataPath.DB_PATH;
	}

	@Override
	public void updateEvent(SQLiteDatabase sqliteDatabase,ConnectionSource connectionSource, int oldVer, int newVer) {
		
	}

	@Override
	public Class<TableEntity>[] getAllTableEntitys() {
		Class[] tables = {
				CapitalRecord.class
		};
		
		return tables;
	}

}
