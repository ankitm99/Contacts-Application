package com.contactsApp.service;

import java.util.List;


import com.contactsApp.entity.Contact;

public interface ContactService {
	
	public List<Contact> getAllContacts();
	
	public List<Contact> getContactsByZipCode(String postalCode);
	
	public Contact createContact(Contact contact);
}
