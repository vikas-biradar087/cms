package com.contact.mangt.system.service;

import java.util.List;

import com.contact.mangt.system.entity.Contact;

public interface ContactService {
	
	public Contact createContact(Contact contact);
	
	
	public Contact getContactById(long id);
	
	
    public Contact updateContact(long id,Contact contactDetails);
    
    
    public void deleteContact(long id);
    
  
    List<Contact> getAllContacts();

}
