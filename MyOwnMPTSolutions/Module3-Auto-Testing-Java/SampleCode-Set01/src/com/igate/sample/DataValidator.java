package com.igate.sample;

import java.util.regex.Pattern;

public class DataValidator {

	public static boolean validateData(String regEx,String data) {
		return Pattern.matches(regEx, data);
	}
}
