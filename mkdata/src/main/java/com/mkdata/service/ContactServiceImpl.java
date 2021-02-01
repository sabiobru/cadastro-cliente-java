package com.mkdata.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.dao.ContactDao;
import com.mkdata.entity.Contact;
import com.mkdata.service.ContactService;
import com.mkdata.vo.ContactVo;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactDao contactDao;
	@Autowired
	ContactVo contactVo;



	@Transactional
	public void insert(List<Contact> contactList) {
		Integer id = contactVo.getId();
		Boolean objectAlreadyExists=contactDao.existsById(id);
		if(!objectAlreadyExists) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(contactVo, contactList);
			contactDao.save(contact);
		}else {
			throw new EntityExistsException();
		}
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=contactDao.existsById(id);
		if(objectExists) {
			contactDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}


}

