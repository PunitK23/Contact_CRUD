package com.punitit.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.punitit.Entity.Contact;

public interface ContactService {

	public Boolean saveContacts(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public Boolean deleteContctById(Integer contactId);

	public Page<Contact> getAllContactsNew(Integer pageNo, Integer pageSize);
	
	public Boolean isContactExists(Contact contact);
	
}
