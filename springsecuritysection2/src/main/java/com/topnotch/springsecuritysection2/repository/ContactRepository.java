package com.topnotch.springsecuritysection2.repository;

import com.topnotch.springsecuritysection2.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
