package com.contactsApp.contactController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contactsApp.entity.Contact;
import com.contactsApp.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	Logger logger = LoggerFactory.getLogger(ContactController.class);
	
	//fetching all contacts
	@GetMapping("getAll")
	public List<Contact> getAllContacts(){
		return contactService.getAllContacts();
	}
	
	//fetching contacts with given postalCode
    @GetMapping(params = "postalCode")
    public List<Contact> getContactsByPostalCode(@RequestParam String postalCode) {
        return contactService.getContactsByZipCode(postalCode);
    }
	
    //Creating contact
	@PostMapping("/create")
	public Contact createStudent(@RequestBody Contact contact) {
		Contact createdContact = contactService.createContact(contact);
		//creating log of created contact with id
		logger.info("Contact created with ID: ", createdContact.getId());
		return createdContact;
	}
	
}
