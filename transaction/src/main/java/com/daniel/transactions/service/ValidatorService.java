package com.daniel.transactions.service;

import org.springframework.stereotype.Service;

import com.daniel.transactions.exception.InvalidRequestException;

@Service
public interface ValidatorService {

	void validate(int id, int year, int month) throws InvalidRequestException;
}
