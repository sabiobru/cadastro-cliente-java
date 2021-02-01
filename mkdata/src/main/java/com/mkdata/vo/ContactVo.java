package com.mkdata.vo;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class ContactVo {

	private Integer id ;

	private String areaCode ;

	private String phoneNumber ;

	private String clientId ;




	public ContactVo(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getAreaCode(){
		return this.areaCode;
	}

	public void setAreaCode(String areaCode){
		this.areaCode = areaCode;
	}

	public String getPhoneNumber(){
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}

	public String getClientId(){
		return this.clientId;
	}

	public void setClientId(String clientId){
		this.clientId = clientId;
	}

}