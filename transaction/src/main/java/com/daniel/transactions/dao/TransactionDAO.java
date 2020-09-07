package com.daniel.transactions.dao;

import java.util.List;

import com.daniel.transactions.entity.Transaction;

public interface TransactionDAO {

	List<Transaction> getAll(int id, int year, int month);
}
