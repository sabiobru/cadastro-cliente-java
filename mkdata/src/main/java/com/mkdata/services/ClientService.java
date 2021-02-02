package com.mkdata.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkdata.domain.Client;
import com.mkdata.domain.Contact;
import com.mkdata.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;
	
	
	
	
	@Autowired
	ContactService contactService;
	
	public Client getById(Integer id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElse(null);
	}
	
	public int getByCpf(String cpf) {
		int total = clientRepository.getByCpf(cpf);
		return total;
	}

	public int getByCnpj(String cnpj) {
		int total = clientRepository.getByCnpj(cnpj);
		return total;
	}

	public List<Client> filterByName(String name) {
		List<Client> clients = clientRepository.filterByName(name);
		return clients;
	}

	public Client saveClient(Client obj) {
		Date date = new Date(System.currentTimeMillis());
		obj.setDate(date);
		obj.setId(null);
		Client cli = clientRepository.save(obj);
		List<Contact> contacts = new ArrayList<>();
		for (Contact tel : obj.getContact()) {
			Contact t = new Contact();
			t.setClient(cli);
			t.setCodeArea(tel.getCodeArea());
			t.setPhoneNumber(tel.getPhoneNumber());
			contacts.add(t);
		}
		contactService.save(contacts);
		return getById(cli.getId());
	}
	
	public Client updateClient(Client obj) {
		Client clientNow = getById(obj.getId());
		clientRepository.save(obj);	
		
		Client cli = clientRepository.save(obj);
		List<Contact> contacts = new ArrayList<>();
		

		for (Contact con : clientNow.getContact()) {
			contactService.delete(con);
		}
		

		for (Contact con : obj.getContact()) {
			Contact c = new Contact();
			c.setClient(cli);
			c.setCodeArea(con.getCodeArea());
			c.setPhoneNumber(con.getPhoneNumber());
			contacts.add(c);
		}
		contactService.save(contacts);
		return getById(cli.getId());
	}
	
	public void delete(Integer id) {
		Client client = getById(id);
		for (Contact con : client.getContact()) {
			contactService.delete(con);
		}
		clientRepository.deleteById(id);
	}
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}
}
