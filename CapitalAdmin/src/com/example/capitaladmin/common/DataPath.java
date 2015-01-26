package com.example.capitaladmin.common;

import java.io.File;

import android.os.Environment;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午2:55:37
 * @author Administrator
 * @version 1.0
 */

public class DataPath {
	private final static String BASE_PATH = Environment.getExternalStorageDirectory() + File.separator + "capital";
	public static final String DB_PATH = BASE_PATH + File.separator + "db";
}
