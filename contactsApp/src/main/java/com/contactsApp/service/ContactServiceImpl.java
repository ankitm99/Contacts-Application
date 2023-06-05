package com.contactsApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactsApp.entity.Address;
import com.contactsApp.entity.Contact;
import com.contactsApp.repository.AddressRepository;
import com.contactsApp.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	AddressRepository addressRepository;

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> getContactsByZipCode(String postalCode) {
		return contactRepository.findByAddressPostalCode(postalCode);
	}

	@Override
	public Contact createContact(Contact contact) {
		Address address = contact.getAddress();
	    addressRepository.save(address);
		
		return contactRepository.save(contact);
	}
	
	
}
