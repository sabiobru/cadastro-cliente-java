package com.mkdata.entity;

import javax.persistence.*;

@Entity
@Table(name="Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id ;

	@Column(name="areaCode")
	private String areaCode ;

	@Column(name="phoneNumber")
	private String phoneNumber ;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Client clientId;


	public Contact(){
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

	public Client getClientId(){
		return this.clientId;
	}

	public void setClientId(Client clientId){
		this.clientId = clientId;
	}

}