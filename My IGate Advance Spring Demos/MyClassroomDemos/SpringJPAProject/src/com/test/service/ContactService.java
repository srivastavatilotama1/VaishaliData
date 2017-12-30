package com.test.service;

import org.springframework.stereotype.Component;

import com.test.vo.Contact;
@Component
public interface ContactService {
	public void addContactInformation(Contact contact);
}
