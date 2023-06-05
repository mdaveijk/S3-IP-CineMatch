package com.cinematch.userdataservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cinematch.userdataservice.models.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {

    User findOne(Long id);

}
