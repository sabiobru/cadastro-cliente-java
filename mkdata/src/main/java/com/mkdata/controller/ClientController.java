package com.mkdata.controller;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.mkdata.service.ClientService;
import com.mkdata.vo.ClientVo;

@RestController
@RequestMapping(value="/client")
public class ClientController {


	@Autowired
	ClientService clientService;

	@RequestMapping("client")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void save(ClientVo clientVo) {
		clientService.save(clientVo);
	}

	@GetMapping("client/{id}")
	public ClientVo get( @PathVariable Integer id) {
		return clientService.get(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<ClientVo> getAll() {
		return clientService.getAll();
	}
	
	@PutMapping("client")
	public void update(ClientVo clientVo) {
		clientService.update(clientVo);
	}
	
	@DeleteMapping("client/{id}")
	public void delete( @PathVariable Integer id) {
		clientService.delete(id);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public String handleEntityExistsException(EntityExistsException e) {
	    return e.getMessage();
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handleEntityNotFoundException(EntityNotFoundException e) {
	    return e.getMessage();
	}
}
