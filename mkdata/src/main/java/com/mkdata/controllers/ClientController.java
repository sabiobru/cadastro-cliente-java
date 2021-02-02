package com.mkdata.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mkdata.domain.Client;
import com.mkdata.services.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController
{
	
	@Autowired
	private ClientService clientService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Client> clients = clientService.findAll();
		return ResponseEntity.ok().body(clients);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Client client = clientService.getById(id);
		return ResponseEntity.ok().body(client);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pesquisaCPF/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> checkCPF(@PathVariable String cpf) {
		int response = clientService.getByCpf(cpf);
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/pesquisaCNPJ/{cnpj}", method = RequestMethod.GET)
	public ResponseEntity<?> checkCNPJ(@PathVariable String cnpj) {
		int response = clientService.getByCnpj(cnpj);
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/filterByName/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> filterByName(@PathVariable String name) {
		List<Client> clients = clientService.filterByName(name);
		return ResponseEntity.ok().body(clients);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> saveClient(@RequestBody Client obj) {
		obj = clientService.saveClient(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClient(@RequestBody Client obj, @PathVariable Integer id){
		obj.setId(id);
		obj = clientService.updateClient(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteClient(@PathVariable Integer id) {
		clientService.delete(id);
		return ResponseEntity.ok().body(true);
	}
	
}
