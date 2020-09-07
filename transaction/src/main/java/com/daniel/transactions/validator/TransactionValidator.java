package com.daniel.transactions.validator;

import com.daniel.transactions.exception.InvalidRequestException;

public interface TransactionValidator {

	void validate(int id, int year, int month) throws InvalidRequestException;
}
