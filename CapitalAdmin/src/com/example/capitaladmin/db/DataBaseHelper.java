package com.example.capitaladmin.db;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.example.capitaladmin.entity.TableEntity;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午2:28:38
 * @author Administrator
 * @version 1.0
 */

public abstract class DataBaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String DATABASE_NAME = "ormlite.db";  
    private static final int DATABASE_VERSION = 1; 
    private String dataBaseFilePath = "";
    private static SQLiteDatabase writableDatabase;
    
    private final String LOG_TAG = "CapitalAdmin";
    Class<TableEntity>[] tables;	//所有数据表
	 
	public DataBaseHelper(Context context, String dbName, int dbVersion) {
		super(context, dbName, null, dbVersion);  
		
		dataBaseFilePath = getDataBaseFilePath();
		tables = getAllTableEntitys();
		
		createDatabaseIfNotExists();
	}
	
	public abstract Class<TableEntity>[] getAllTableEntitys();
	public abstract String getDataBaseFilePath();
	
	private void createDatabaseIfNotExists(){
		File file = new File(dataBaseFilePath);
		if (!file.exists()||!file.isFile()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Log.e("CapitalAdmin", "新建数据库文件失败！");
				e.printStackTrace();
			}
			SQLiteDatabase sqLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
			getWritableDatabase().setVersion(DATABASE_VERSION);
			if (sqLiteDatabase!=null&&sqLiteDatabase.isOpen()) {
				sqLiteDatabase.close();
			}
			onCreate(getWritableDatabase(),getConnectionSource());
			getWritableDatabase().setVersion(DATABASE_VERSION);
		}else {
			//如果文件已经存在，则不进行操作
			updateEvent(getWritableDatabase(), connectionSource, getWritableDatabase().getVersion(), DATABASE_VERSION);
			getWritableDatabase().setVersion(DATABASE_VERSION);
			return ;
		}
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		if (tables == null || tables.length < 1) {
			Log.w(LOG_TAG,"没有任何数据表被创建，请实现TableEntity[] getAllTableEntitys()方法！");
		}
		try {
			Log.i(LOG_TAG, "onCreate");
			// 建表
			if (tables != null && tables.length > 0) {
				for (int i = 0; i < tables.length; i++) {
					Class<TableEntity> table = tables[i];
					if (table != null) {
						TableUtils.createTable(connectionSource, table);
						Log.d(LOG_TAG, "创建数据表：" + table);
					}
				}
			}
		} catch (SQLException e) {
			Log.e(LOG_TAG, "Can't create database", e);
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public synchronized SQLiteDatabase getWritableDatabase() {
		if (writableDatabase==null||!writableDatabase.isOpen()) {
			writableDatabase = SQLiteDatabase.openDatabase(dataBaseFilePath, null,SQLiteDatabase.OPEN_READWRITE);
		}
		return writableDatabase;
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,int arg3) {
		
	}
	
	public abstract void updateEvent(SQLiteDatabase sqliteDatabase, ConnectionSource connectionSource, int oldVer, int newVer);

}
