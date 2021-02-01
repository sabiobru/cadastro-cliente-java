package com.mkdata.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id ;

	@Column(name="name")
	private String name ;

	@Column(name="type")
	private Boolean type ;

	@Column(name="identityDocument")
	private String identityDocument ;

	@Column(name="registrationNumber")
	private String registrationNumber ;

	@Column(name="registrationDate")
	private String registrationDate ;

	@Column(name="status")
	private Boolean status ;

	@OneToMany(mappedBy = "client")
	private List<Contact> contactList = new ArrayList<>();


	public Client(){
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


	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList (List<Contact> contactList) {
		this.contactList = contactList;
	}


}