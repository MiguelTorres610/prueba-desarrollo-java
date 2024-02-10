package com.customers.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customers.dto.CustomerDto;
import com.customers.service.CustomerService;
import com.customers.util.Message;

@RestController
//@RequestMapping("api/v1/")
public class CustomerController {

	private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService service;

	@GetMapping(value = "/customers", produces = { "application/json" })
	public List<CustomerDto> getAllCustomers() {
		try {
			return service.getAllCustomersMock();
		} catch (Exception e) {
			logger.error(Message.SERVICE_UNAVAILABLE, e);
		}
		return null;
	}

//	@GetMapping(value = "/card/{productId}", produces = { "application/json" })
//	public ResponseEntity<ResponseDto> findCardById(@PathVariable(name = "productId") Long productId) {
//		return new ResponseEntity<ResponseDto>(service.findCardById(productId), HttpStatus.OK);
//	}
//
//	@PutMapping(value = "/card/create", consumes = { "application/json" }, produces = { "application/json" })
//	public ResponseEntity<ResponseDto> createCard(@RequestBody(required = true) RequestDto request) {
//		return new ResponseEntity<ResponseDto>(service.createCard(request), HttpStatus.CREATED);
//	}
//
//	@GetMapping(value = "/card/{productId}/number", produces = { "application/json" })
//	public ResponseEntity<ResponseDto> generateCardNumber(@PathVariable(name = "productId") Long productId) {
//		return new ResponseEntity<ResponseDto>(service.generateCardNumber(productId), HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/card/enroll", consumes = { "application/json" }, produces = { "application/json" })
//	public ResponseEntity<ResponseDto> activateCard(@RequestBody(required = true) RequestDto request) {
//		return new ResponseEntity<ResponseDto>(service.activateCard(request.getCardId().toString()), HttpStatus.OK);
//	}
//
//	@DeleteMapping(value = "/card/{cardId}", produces = { "application/json" })
//	public ResponseEntity<ResponseDto> blockCard(@PathVariable(name = "cardId") Long cardId) {
//		return new ResponseEntity<ResponseDto>(service.blockCard(cardId), HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/card/balance", consumes = { "application/json" }, produces = { "application/json" })
//	public ResponseEntity<ResponseDto> rechargeCardBalance(@RequestBody(required = true) RequestDto request) {
//		return new ResponseEntity<ResponseDto>(service.rechargeCardBalance(request), HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/card/balance/{cardId}", produces = { "application/json" })
//	public ResponseEntity<ResponseDto> getCardBalance(@PathVariable(name = "cardId") Long cardId) {
//		return new ResponseEntity<ResponseDto>(service.getCardBalance(cardId), HttpStatus.OK);
//	}
}
