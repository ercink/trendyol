package com.trend.trendyol.constant;

public class DataUtil {
	
	public static boolean isNullOrEmpty(String data) {
		if (data == null) {
			return true;
		}
		if (data.trim().length() == 0) {
			return true;
		}
		return false;
	}

}
