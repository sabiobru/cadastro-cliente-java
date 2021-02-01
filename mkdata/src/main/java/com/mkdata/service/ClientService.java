package com.mkdata.service;

import java.util.List;

import com.mkdata.vo.ClientVo;

public interface ClientService {

	void save(ClientVo clientVo) ;
	void update(ClientVo clientVo) ;
	void delete(Integer id);
	ClientVo get(Integer id);
	List<ClientVo> getAll();

}

