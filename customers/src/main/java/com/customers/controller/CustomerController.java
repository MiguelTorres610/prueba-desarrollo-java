package com.customers.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.customers.dto.CustomerDto;
import com.customers.service.CustomerService;
import com.customers.util.Message;

@RestController
//@RequestMapping("api/v1/")
public class CustomerController {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;

	@GetMapping("/home")
	public ModelAndView getAllCustomersView() {
		try {
			ModelAndView mav = new ModelAndView("customers-list");
			mav.addObject("customers", service.getAllCustomers());
			return mav;
		} catch (Exception e) {
			logger.error(Message.SERVICE_UNAVAILABLE, e);
		}
		return null;
	}

	@GetMapping("/add-customer")
	public ModelAndView addCustomerView() {
		ModelAndView mav = new ModelAndView("customer");
		mav.addObject("customer", new CustomerDto());
		return mav;
	}

	@PostMapping("/save-customer")
	public ModelAndView saveCustomerView(@ModelAttribute CustomerDto customerDto) {
		try {
			service.saveCustomer(customerDto);
			ModelAndView mav = new ModelAndView("customers-list");
			mav.addObject("customers", service.getAllCustomers());
			return mav;
		} catch (Exception e) {
			logger.error(Message.SERVICE_UNAVAILABLE, e);
		}
		return null;
	}

	@GetMapping(value = "/customers", produces = { "application/json" })
	public List<CustomerDto> getAllCustomers() {
		try {
			return service.getAllCustomers();
		} catch (Exception e) {
			logger.error(Message.SERVICE_UNAVAILABLE, e);
		}
		return null;
	}

	@PostMapping(value = "/customers", consumes = { "application/json" }, produces = { "application/json" })
	public void saveCustomer(@RequestBody(required = true) CustomerDto customerDto) {
		try {
			service.saveCustomer(customerDto);
		} catch (Exception e) {
			logger.error(Message.SERVICE_UNAVAILABLE, e);
		}
	}

	@GetMapping(value = "/customers/mock", produces = { "application/json" })
	public List<CustomerDto> getAllCustomersMock() {
		try {
			return service.getAllCustomersMock();
		} catch (Exception e) {
			logger.error(Message.SERVICE_UNAVAILABLE, e);
		}
		return null;
	}
}
