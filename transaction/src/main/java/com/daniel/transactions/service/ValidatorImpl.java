package com.daniel.transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.validator.TransactionValidator;

@Component
public class ValidatorImpl {
	@Autowired
	private TransactionValidator transactionValidator;

	public void validate(int id, int year, int month) throws InvalidRequestException {
		transactionValidator.validate(id, year, month);
	}
}
