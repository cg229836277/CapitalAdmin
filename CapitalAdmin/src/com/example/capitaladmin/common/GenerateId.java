package com.example.capitaladmin.common;

import java.util.Date;
import java.util.UUID;

public class GenerateId {
	public static String sequenceId(){
		String id = UUID.randomUUID().toString();
		id = id.substring(0 , 8);
		if(!StringUtil.isEmpty(id)){
			return id;
		}else{
			return new Date(System.currentTimeMillis()).toString();
		}
	}
}
