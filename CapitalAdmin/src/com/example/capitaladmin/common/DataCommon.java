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
	
	public final static String[] COST_TYPE_DATA = {"SUPERMARKET_SHOPPING" , "RESTAURANT" , "CLOTH",
		"SHOPPING_ONLINE","TRAVEL","GIFT","HOUSE_RENT","BUS_TRAFFIC","HOSPITAL","OTHERS_COST"};
	public final static String[] INCOME_TYPE_DATA = {"POKET_MONEY","YEAR_GIFT","SALARY","REWARD","LOTTERY","OTHERS_INCOME"};
	
	public final static String SUPERMARKET_SHOPPING = "SUPERMARKET_SHOPPING";
	public final static String RESTAURANT = "RESTAURANT";
	public final static String CLOTH = "CLOTH";
	public final static String SHOPPING_ONLINE = "SHOPPING_ONLINE";
	public final static String TRAVEL = "TRAVEL";
	public final static String GIFT = "GIFT";
	public final static String HOUSE_RENT = "HOUSE_RENT";
	public final static String BUS_TRAFFIC = "BUS_TRAFFIC";
	public final static String HOSPITAL = "HOSPITAL";
	public final static String OTHERS_COST = "OTHERS_COST";
	
	public final static String POKET_MONEY = "POKET_MONEY";
	public final static String YEAR_GIFT = "YEAR_GIFT";
	public final static String SALARY = "SALARY";
	public final static String REWARD = "REWARD";
	public final static String LOTTERY = "LOTTERY";
	public final static String OTHERS_INCOME = "OTHERS_INCOME";
	
	public final static String[] SEARCH_TYPE = {"本年度", "本季度" , "本月" , "本周"};
	
	public final static String[] COSTTYPE = {"请选择支出类型" , "超市购物" , "下馆子" , "服装" , 
		"在线购物" , "旅行费用" , "礼物" , "房租水电" , "公共交通" , "医药费" , "其他"};
	
	public final static String[] INCOMTYPE = {"请选择收入类型" , "零花钱" , "压岁钱" , "工资" , "奖金" , "彩票" , "其他"};
}
