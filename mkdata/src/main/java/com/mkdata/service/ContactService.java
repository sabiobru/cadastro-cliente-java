package com.mkdata.service;

import java.util.List;

import com.mkdata.dao.ContactDao;
import com.mkdata.entity.Contact;
import com.mkdata.vo.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;

public interface ContactService {


	void insert (List<Contact> contacts);
	void delete (Integer id);



}

