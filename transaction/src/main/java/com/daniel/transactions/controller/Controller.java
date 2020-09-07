package com.daniel.transactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.service.TransactionService;
import com.daniel.transactions.validator.GetTransactionsValidator;

/**
 * The rest controller that will handle all rest endpoints.
 */
@RestController
public class Controller {

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private GetTransactionsValidator getTransactionsValidator;

	/**
	 * Returns an list of transactions.
	 *
	 * @param id    The id of the user.
	 * @param year  The year of the transaction.
	 * @param month The month of the transaction
	 * @return List<{@link Transaction} Returns a list of the transactions in the
	 *         specific year and month of that user.
	 * @throws InvalidRequestException If the request is wrong.
	 */
	@GetMapping("/{id}/transacoes/{year}/{month}")
	public ResponseEntity<List<Transaction>> getTransacoes(@PathVariable int id, @PathVariable int year,
			@PathVariable int month) throws InvalidRequestException {

		getTransactionsValidator.validate(id, year, month);

		List<Transaction> response = transactionService.getAll(id, year, month);

		return ResponseEntity.ok().body(response);
	}
}
