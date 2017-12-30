package com.igate.demos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Mapping {

	public static void main(String[] args) {
		
		List<String> locations = Arrays.asList(new String[]{"Pune","Mumbai","Chennai","Banglore","Noida"});
		Stream<String> stream = locations.stream();
		System.out.println("Word legnth for locations:");
		stream.map(String::length).forEach(System.out::print);
		
	}
}
