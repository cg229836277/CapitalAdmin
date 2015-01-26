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

	// 文件另存名字
	@DatabaseField(columnName = "id")
	private String id;
}
