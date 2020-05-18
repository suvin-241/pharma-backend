package com.pharma.itsmypharma.common;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class QueryConstants {
	public static final String ARG1 = "arg1";
	public static final String ARG2 = "arg2";

	public static final String GET_BY_EMAIL = "getbyemail";
	public static final String GET_BY_MOBILE_NO = "getbymobileno";

	private static Map<String, StringBuilder> queryMap;

	static {
		queryMap = new HashMap<String, StringBuilder>() {
			{
				put(GET_BY_EMAIL, new StringBuilder("from User u where u.userEmail =:").append(ARG1));
				put(GET_BY_MOBILE_NO, new StringBuilder("from User u where u.mobileNo =:").append(ARG1));

			}
		};

	}

	public static String getQuery(String key) {
		return queryMap.get(key).toString();
	}
}
