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

public class DataCommon {
	private final static String BASE_PATH = Environment.getExternalStorageDirectory() + File.separator + "capital";
	public static final String DB_PATH = BASE_PATH + File.separator + "db";
	
	public final static String FOOD = "FOOD";
	public final static String DAILY = "DAILY";
	public final static String RESTAURANT = "RESTAURANT";
	public final static String CLOTH = "CLOTH";
	public final static String SHOES = "SHOES";
	public final static String SHOPPING_ONLINE = "SHOPPING_ONLINE";
	public final static String TICKET = "TICKET";
	public final static String GIFT = "GIFT";
	public final static String HOTEL = "HOTEL";
	public final static String BOOKS = "BOOKS";
	public final static String OTHERS = "OTHERS";
	public final static String POCKET_MONKEY = "POCKET_MONKEY";
	public final static String YEAR_MONKEY = "YEAR_MONKEY";
	public final static String SALARY = "SALARY";
	public final static String REWARD = "REWARD";
	public final static String LOTTERY = "LOTTERY";
	public final static String OTHERS_INCOM = "OTHERS_INCOM";
	
	public final static String[] COSTTYPE = {"柴米油盐" , "日常用品" , "下馆子" , "衣服" , "鞋子" , 
		"在线购物" , "车票飞机票" , "礼物" , "住宿" , "文体" , "其他"};
	
	public final static String[] INCOMTYPE = {"零花钱" , "压岁钱" , "工资" , "奖金" , "彩票" , "其他"};
}
