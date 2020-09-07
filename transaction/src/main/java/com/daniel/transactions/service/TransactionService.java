package com.daniel.transactions.service;

import java.util.List;

import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.exception.InvalidRequestException;

/**
 * Generic class of commands.
 */
public interface TransactionService {

	/**
	 * Executes the commands.
	 *
	 * @return List<{@link Entity}> Returns a list of entities after the execution
	 *         of the command.
	 * @throws InvalidRequestException If a request is not valid.
	 */
	List<Transaction> getAll(int id, int year, int month) throws InvalidRequestException;
}
