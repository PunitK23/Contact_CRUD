package com.punitit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.punitit.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
