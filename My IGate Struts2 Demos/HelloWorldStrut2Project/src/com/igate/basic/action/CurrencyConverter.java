package com.igate.basic.action;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.igate.dto.Currency;

public class CurrencyConverter extends StrutsTypeConverter {
    @Override
    public Object convertFromString(Map context, String[] values, Class clazz) {
    Currency cun = new Currency(values[0]);
    return cun;
 }

 @Override
 public String convertToString(Map context, Object value) {
	 Currency cur  = (Currency) value;
    return cur == null ? null : cur.getCurrencyValue();
 }

}
