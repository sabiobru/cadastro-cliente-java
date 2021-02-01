package com.mkdata.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import com.mkdata.entity.Contact;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.dao.ClientDao;
import com.mkdata.entity.Client;

import com.mkdata.vo.ClientVo;

@Service
public class ClientServiceImpl {

	@Autowired
	ClientDao clientDao;

	@Autowired
	ContactService contactService;

	@Transactional
	public ClientVo save (Client client) {
		Integer id = client.getId();
		Date dateNow = new Date(System.currentTimeMillis());
		client.setId(null);
		Client cli = clientDao.save(client);
		List<Contact> contacts = new ArrayList<>();
		Boolean objectAlreadyExists = clientDao.existsById(id);
		for (Contact tel : client.getContactList()) {
			Contact c = new Contact();
			c.setClientId(cli);
			c.setAreaCode(tel.getAreaCode());
			c.setPhoneNumber(tel.getPhoneNumber());
			contacts.add(c);
		}
		contactService.insert(contacts);

		return get(cli.getId());
	}



	@Transactional
	public void update(ClientVo clientVo) {
		Integer id = clientVo.getId();
		Boolean objectExists=clientDao.existsById(id);
		if(objectExists) {
			Client client = new Client();
			BeanUtils.copyProperties(clientVo, client);
			clientDao.save(client);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Transactional
	public void delete(Integer id) {
		Boolean objectExists=clientDao.existsById(id);
		if(objectExists) {
			clientDao.deleteById(id);
		}else {
			throw new EntityNotFoundException();
		}
	}

	@Transactional
	public ClientVo get(Integer id) {
		Optional<Client> clientOptional = clientDao.findById(id);
		ClientVo clientVo=null;
		if(clientOptional.isPresent()) {
			clientVo = new ClientVo();
			BeanUtils.copyProperties(clientOptional.get(), clientVo);	
		}else {
			throw new EntityNotFoundException();
		}
		
		return clientVo;
	}

	@Transactional
	public List<ClientVo> getAll(List<Contact> contactList) {
		List<Client> clientList = clientDao.findAll();
		List<ClientVo> clientVoList = new ArrayList<>();
		if (clientList != null && !clientList.isEmpty()) {
			for (Client client : clientList) {
				ClientVo clientVo = new ClientVo();
				BeanUtils.copyProperties(client, clientVo);
				clientVoList.add(clientVo);
			}
		}
		return clientVoList;
	}

}

