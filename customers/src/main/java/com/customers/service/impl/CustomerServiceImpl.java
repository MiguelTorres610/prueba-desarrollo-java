package com.customers.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.customers.dto.CustomerDto;
import com.customers.model.Customer;
import com.customers.repository.CustomerRepository;
import com.customers.service.CustomerService;
import com.customers.util.Message;

import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	private ModelMapper modelMapper;

	public CustomerServiceImpl() {
		this.modelMapper = new ModelMapper();
	}

	/**
	 * 
	 */
	@Override
	public List<CustomerDto> getAllCustomers() throws Exception {
		List<CustomerDto> customerList = new ArrayList<>();
		try {
			customerList = customerRepository.findAll().stream()
					.map(entity -> modelMapper.map(entity, CustomerDto.class)).collect(Collectors.toList());
			logger.info("CustomerServiceImpl.getAllCustomers successful");
			return customerList;
		} catch (DataAccessException e) {
			logger.error(Message.INTERNAL_ERROR);
		}
		return customerList;
	}

	/**
	 * 
	 */
	@Override
	public void saveCustomer(CustomerDto customerDto) throws Exception {
		try {
			Customer customer = new Customer();
			customer.setName(customerDto.getName());
			customer.setAge(customerDto.getAge());
			customer.setPhoneNumber(customerDto.getPhoneNumber());
			customer.setAddress(customerDto.getAddress());

			customerRepository.saveAndFlush(customer);
			logger.info("CustomerServiceImpl.saveCustomer successful");
		} catch (DataAccessException e) {
			logger.error(Message.INTERNAL_ERROR);
		}
	}

	/**
	 * 
	 */
	@Override
	public void updateCustomer(CustomerDto customerDto) throws Exception {
		try {
			Customer customer = new Customer();
			customer.setName(customerDto.getName());
			customer.setAge(customerDto.getAge());
			customer.setPhoneNumber(customerDto.getPhoneNumber());
			customer.setAddress(customerDto.getAddress());

			customerRepository.saveAndFlush(customer);
			logger.info("CustomerServiceImpl.updateCustomer successful");
		} catch (DataAccessException e) {
			throw new Exception("Cannot access the database");
		}
	}

	/**
	 * 
	 */
	@Override
	public List<CustomerDto> getAllCustomersMock() {

		try {
		
		WebClient webClient = WebClient
				.builder()
				.baseUrl("https://8e7c6b8a-fc46-4674-a529-4ebec57295d3.mock.pstmn.io")
				.build();

		Mono<String> response = webClient.get()
				.uri("/customers")
				.accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(String.class).log();

		logger.info("RESPONSE: ", response.block());
		
		
		} catch (Exception e) {
			logger.error("Error al consumir servicio web: ", e);
		}
		return null;
	}
}
