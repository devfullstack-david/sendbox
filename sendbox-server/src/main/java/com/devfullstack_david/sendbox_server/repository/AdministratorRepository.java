package com.devfullstack_david.sendbox_server.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devfullstack_david.sendbox_server.model.Administrator;

@Repository
public interface AdministratorRepository extends MongoRepository<Administrator, String> {}
