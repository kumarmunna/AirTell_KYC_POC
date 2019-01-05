package com.custoemrRegistration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.custoemrRegistration.model.UserRegistration;

public interface DataRepository extends JpaRepository<UserRegistration, Integer>{

}
