package com.igate.demos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		
		List<String> values = Arrays.asList("one","Two","three","Four","five");
		Collections.sort(values,String::compareToIgnoreCase);
		System.out.println(values);
	}
}
