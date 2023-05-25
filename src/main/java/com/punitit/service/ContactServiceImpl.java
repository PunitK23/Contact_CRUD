package com.punitit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.punitit.Entity.Contact;
import com.punitit.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepo;
	
	public ContactServiceImpl(ContactRepository contactRepo) {
	this.contactRepo = contactRepo;
	}
	
	@Override
	public Boolean saveContacts(Contact contact) {
		contact.setActiveSw("Y");
		Contact savedEntity = contactRepo.save(contact);
		if(savedEntity != null && savedEntity.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		Contact contactFilter = new Contact();
		contactFilter.setActiveSw("Y");
		Example<Contact> example = Example.of(contactFilter);
		return contactRepo.findAll(example);
	}
	
	@Override
	public Page<Contact> getAllContactsNew(Integer pageNo, Integer pageSize) {
		Contact contactFilter = new Contact();
		contactFilter.setActiveSw("Y");
		Example<Contact> example = Example.of(contactFilter);
		
		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		return contactRepo.findAll(example, pageRequest);
			
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public Boolean deleteContctById(Integer contactId) {

//		boolean existsById = contactRepo.existsById(contactId);
//		if(existsById) {	
//			contactRepo.deleteById(contactId);
//			return true;
//		}
//		return false;
		
		Optional<Contact> findById = contactRepo.findById(contactId);
		if(findById.isPresent()) {
			Contact contact = findById.get();
			contact.setActiveSw("N");
			contactRepo.save(contact);
			return true;
		}
		return false;
	}

	@Override
	public Boolean isContactExists(Contact contact) {
		
		Example<Contact> example = Example.of(contact);
		return contactRepo.exists(example);
		
//		List<Contact> contacts = contactRepo.findAll(example);
//		if(!contacts.isEmpty()) {
//			return true;
//		}
//		return false;
	}

}
