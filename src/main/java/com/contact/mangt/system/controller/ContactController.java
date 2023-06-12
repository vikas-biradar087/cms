package com.contact.mangt.system.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.contact.mangt.system.entity.Contact;
import com.contact.mangt.system.payload.ApiResponse;
import com.contact.mangt.system.service.ContactService;


@RestController
@RequestMapping("/contactApi")
public class ContactController {
	
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	
	//localhost:8080/contactApi/contact
	@PostMapping("/contact")
	public ResponseEntity<Contact> createPost(@RequestBody Contact contact) {
		this.contactService.createContact(contact);
		return new ResponseEntity<Contact>(HttpStatus.CREATED);
	}
	
	
	//localhost:8080/contactApi
	@GetMapping
	public ResponseEntity<List<Contact>> getAll(){
		return  ResponseEntity.ok(this.contactService.getAllContacts());
		
	}
	
	
	//localhost:8080/contactApi/1
	@GetMapping("/{id}")
	public ResponseEntity<Contact> getById(@PathVariable long id ){
		return ResponseEntity.ok(this.contactService.getContactById(id));
	}
	
	
	//localhost:8080/contactApi/update/1
	@PutMapping("/update/{id}")
	public ResponseEntity<ApiResponse> updateUser(@RequestBody  Contact contactDetails, @PathVariable("id") long id){
	 this.contactService.updateContact(id, contactDetails);
	return new ResponseEntity<ApiResponse>(new ApiResponse("Contact Update successfully !!", true),HttpStatus.OK);
	}
	
	
	//localhost:8080/contactApi/delete/1
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ApiResponse> deleteRecord(@PathVariable("id") long id){
		contactService.deleteContact(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Contact deleted successfully !!",true),HttpStatus.OK);
	}

}
