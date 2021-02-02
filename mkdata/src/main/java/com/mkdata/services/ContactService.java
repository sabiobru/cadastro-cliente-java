package com.mkdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.domain.Contact;
import com.mkdata.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	public void save(List<Contact> contact) {
		for (Contact con : contact) {
			contactRepository.save(con);
		}
	}
	
	public void delete(Contact contact) {
		contactRepository.delete(contact);
	}
	
	
}
