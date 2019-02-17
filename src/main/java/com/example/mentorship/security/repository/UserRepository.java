package com.example.mentorship.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mentorship.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
