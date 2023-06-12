package com.contact.mangt.system.service;

import java.util.List;
import org.springframework.stereotype.Service;


import com.contact.mangt.system.entity.Contact;
import com.contact.mangt.system.exception.ResourceNotFoundException;
import com.contact.mangt.system.respository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	 private ContactRepository contactRepo;
	 
	 
	 public ContactServiceImpl(ContactRepository contactRepo) {
			super();
			this.contactRepo = contactRepo;
		}
	 
	 
	 
	@Override
	public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

	
	@Override
	public List<Contact> getAllContacts() {
        return contactRepo.findAll();
    }

	
	
	@Override
	public Contact getContactById(long id) {
		return contactRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Contact","id", id));
    }
	


	@Override
	public Contact updateContact(long id, Contact contactDetails) {
		Contact contact = contactRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact not found",id,contactDetails));
		contact.setFirstName(contactDetails.getFirstName());
		contact.setLastName(contactDetails.getLastName());
		contact.setEmail(contactDetails.getEmail());
		contact.setPhone(contactDetails.getPhone());
		return contactRepo.save(contact);
	}

	
	@Override
	public void deleteContact(long id) {
	Contact con = contactRepo.findById(id).orElseThrow(
			
			()-> new ResourceNotFoundException("Contact", "id", id));
	
		this.contactRepo.delete(con);
	}


}
