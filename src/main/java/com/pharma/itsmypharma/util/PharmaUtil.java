package com.pharma.itsmypharma.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PharmaUtil {

	public static String encrypt(String value) {
		StringBuilder sb = null;
		try {
			sb = new StringBuilder();
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(value.getBytes());

			byte[] bytes = md.digest();

			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
