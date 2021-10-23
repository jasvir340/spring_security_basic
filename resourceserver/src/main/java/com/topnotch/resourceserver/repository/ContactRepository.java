package com.topnotch.resourceserver.repository;

import com.topnotch.resourceserver.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {


}
