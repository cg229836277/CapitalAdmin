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

@DatabaseTable(tableName = "capital_record")
public class CapitalRecord implements Serializable{
 
	private static final long serialVersionUID = 1L;
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

	//主键id
	@DatabaseField(id = true)
	private String id;
	
	//支出类型
	@DatabaseField(columnName = "type")
	private String type;
	
	//支出的组成部分
	@DatabaseField(columnName = "cost_type")
	private String costType;
	
	//支出时间
	@DatabaseField(columnName = "time")
	private String time;
	
	//支出年
	@DatabaseField(columnName = "year")
	private String year;
	
	//支出月
	@DatabaseField(columnName = "month")
	private String month;
	
	//支出星期
	@DatabaseField(columnName = "week")
	private String week;
	
	//支出日
	@DatabaseField(columnName = "day")
	private String day;
	
	//支出金额
	@DatabaseField(columnName = "count")
	private String count;
	 
	//支出人
	@DatabaseField(columnName = "people")
	private String people;
	
	//支出地点
	@DatabaseField(columnName = "place")
	private String place;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}
}
