package com.mkdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkdata.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
}
