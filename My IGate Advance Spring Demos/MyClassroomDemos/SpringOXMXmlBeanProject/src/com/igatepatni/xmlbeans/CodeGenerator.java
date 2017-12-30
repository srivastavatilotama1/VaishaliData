package com.igatepatni.xmlbeans;

import org.apache.xmlbeans.impl.tool.SchemaCompiler;

public class CodeGenerator {

	public static void main(String[] args) {
		
		String[] params = new String[]{"scomp", "message.xsd"};		
		SchemaCompiler.main(params);
		System.out.println("This is done.......");
		
		
		
	}
}