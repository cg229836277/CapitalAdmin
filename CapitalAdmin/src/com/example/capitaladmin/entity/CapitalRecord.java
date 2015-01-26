package com.example.capitaladmin.entity;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


 /**
 * @Title：FashionDIY
 * @Description：
 * @date 2015-1-26 下午3:05:00
 * @author Administrator
 * @version 1.0
 */

@DatabaseTable(tableName = "sys_attachment")
public class CapitalRecord implements Serializable{
 
	private static final long serialVersionUID = 1L;
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

	//主键id
	@DatabaseField(columnName = "id")
	private String id;
	
	//支出类型
	@DatabaseField(columnName = "type")
	private String type;
	
	//支出时间
	@DatabaseField(columnName = "time")
	private String time;
	
	//支出金额
	@DatabaseField(columnName = "count")
	private String count;
	
	//支出人
	@DatabaseField(columnName = "people")
	private String people;
	
	//支出地点
	@DatabaseField(columnName = "place")
	private String place;
}
