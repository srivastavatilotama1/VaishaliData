package com.igate.demos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Filtering {

	public static void main(String[] args) {
		
		List<String> locations = Arrays.asList(new String[]{"Pune","Mumbai","Chennai","Banglore","Noida"});
		Stream<String> stream = locations.stream();
		stream.filter((location)->location.length()>5).forEach(System.out::println);
		
	}
}
