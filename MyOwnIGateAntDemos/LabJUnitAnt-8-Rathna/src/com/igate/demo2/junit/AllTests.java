package com.igate.demo2.junit;

import org.junit.runner.RunWith;  
import org.junit.runners.Suite;  

import com.igate.demo2.util.test.Addition_test;
import com.igate.demo2.util.test.Multiply_test;


@RunWith(Suite.class)  
@Suite.SuiteClasses({Addition_test.class,Multiply_test.class})  
public class AllTests  
{  
	
} 
