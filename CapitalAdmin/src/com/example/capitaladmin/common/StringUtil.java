package com.example.capitaladmin.common;

public class StringUtil {

	public static boolean isEmpty(String str){
		if(str != null){
			if(!"".equals(str)){
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}
	}
}
