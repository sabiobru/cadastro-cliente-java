package com.mkdata.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //*** para gerar ID automaticos
	private Integer id;
	
	private String name;
	private String cpf;
	private String cnpj;
	private int type;
	private String ie;
	private String rg;
	private Date date;
	private int status;
	

	@OneToMany(mappedBy = "client")
	private List<Contact> contacts = new ArrayList<>();
	
	public Client() {
	}

	public Client(Integer id, String name, String cpf, String cnpj, int type, String ie, String rg, Date date, int status) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.type = type;
		this.ie = ie;
		this.rg = rg;
		this.date = date;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getIe() {
		return ie;
	}


	public void setIe(String ie) {
		this.ie = ie;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getAtivo() {
		return status;
	}


	public void setAtivo(int status) {
		this.status = status;
	}


	public List<Contact> getContact() {
		return contacts;
	}


	public void setContact(List<Contact> contacts) {
		this.contacts = contacts;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", cpf=" + cpf + ", cnpj=" + cnpj + ", type="
				+ type + ", ie=" + ie + ", rg=" + rg + ", date=" + date + ", status=" + status
				+ ", contacts=" + contacts + "]";
	}

	


}
