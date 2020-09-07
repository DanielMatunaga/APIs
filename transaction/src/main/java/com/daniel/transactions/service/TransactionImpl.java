package com.daniel.transactions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.transactions.dao.TransactionDAO;
import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.exception.InvalidRequestException;

/**
 * Command that will execute a get transaction.
 */
@Component
public class TransactionImpl implements TransactionService {

	@Autowired
	private TransactionDAO transactionDao;

	@Override
	public List<Transaction> getAll(int id, int year, int month) throws InvalidRequestException {
		return transactionDao.getAll(id, year, month);
	}
}
