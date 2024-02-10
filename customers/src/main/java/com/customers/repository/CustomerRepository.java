package com.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customers.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findCustomerByName(String name);
}
