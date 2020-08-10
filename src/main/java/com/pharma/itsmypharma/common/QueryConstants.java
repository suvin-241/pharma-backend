package com.pharma.itsmypharma.common;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class QueryConstants {
	public static final String ARG1 = "arg1";
	public static final String ARG2 = "arg2";

	public static final String GET_MEDICINE_BY_SEARCH_KEY = "getMedicineBySerachKey";
	public static final String GET_CUSTOMER_BY_MOBOLE_NO="getCustomerByMobileNo";

	private static Map<String, StringBuilder> queryMap;

	static {
		queryMap = new HashMap<String, StringBuilder>() {
			{
				put(GET_MEDICINE_BY_SEARCH_KEY,
						new StringBuilder("from MedicalMaster m where upper(m.drugName) like :").append(ARG1));
				
				put(GET_CUSTOMER_BY_MOBOLE_NO,new StringBuilder("from Customer c where c.mobileNo=:").append(ARG1));
			}
		};

	}

	public static String getQuery(String key) {
		return queryMap.get(key).toString();
	}
}
