package com.daniel.transactions.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.mock.TransactionMock;

/**
 * Data access class to do interface between the database and the application.
 */
@Component
public class TransactionDAOImpl implements TransactionDAO {

	@Autowired
	private TransactionMock transactionMock;

	@Override
	public List<Transaction> getAll(int id, int year, int month) {
		// If someday we resolve to implement a real API we can change to use a Database
		// instead of a mock
		return transactionMock.generateTransactions(id, year, month);
	}
}
