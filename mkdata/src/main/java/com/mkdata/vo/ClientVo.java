package com.mkdata.vo;

public class ClientVo {

	private Integer id ;

	private String name ;

	private Boolean type ;

	private String identityDocument ;

	private String registrationNumber ;

	private String registrationDate ;

	private Boolean status ;

	public ClientVo(){
		super();
	}

	public Integer getId(){
		return this.id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Boolean getType(){
		return this.type;
	}

	public void setType(Boolean type){
		this.type = type;
	}

	public String getIdentityDocument(){
		return this.identityDocument;
	}

	public void setIdentityDocument(String identityDocument){
		this.identityDocument = identityDocument;
	}

	public String getRegistrationNumber(){
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber){
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationDate(){
		return this.registrationDate;
	}

	public void setRegistrationDate(String registrationDate){
		this.registrationDate = registrationDate;
	}

	public Boolean getStatus(){
		return this.status;
	}

	public void setStatus(Boolean status){
		this.status = status;
	}

}