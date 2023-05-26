package com.cinematch.userdataservice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinematch.userdataservice.models.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

}
