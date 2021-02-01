package com.mkdata.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mkdata.entity.Contact;

@Repository
public interface ContactDao extends JpaRepository<Contact, Integer>{

}