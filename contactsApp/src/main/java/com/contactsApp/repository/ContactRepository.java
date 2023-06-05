package com.contactsApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.contactsApp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{
	public List<Contact> findByAddressPostalCode(String postalCode);
}
