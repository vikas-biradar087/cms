package com.contact.mangt.system.respository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.contact.mangt.system.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
