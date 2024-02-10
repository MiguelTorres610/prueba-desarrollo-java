package com.customers.service;

import java.util.List;

import com.customers.dto.CustomerDto;

public interface CustomerService {	

	public List<CustomerDto> getAllCustomers() throws Exception;

	public void saveCustomer(CustomerDto customerDto) throws Exception;

	public void updateCustomer(CustomerDto customerDto) throws Exception;

	public List<CustomerDto> getAllCustomersMock() throws Exception;

}
