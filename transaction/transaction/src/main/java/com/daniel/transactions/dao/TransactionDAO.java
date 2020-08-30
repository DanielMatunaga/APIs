package com.daniel.transactions.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.mock.TransactionMockService;

/**
 * Data access class to do interface between the database and the application.
 */
@Component
public class TransactionDAO implements GenericDAO<Transaction>
{
    @Autowired
    private TransactionMockService transactionMock;

    @Override
    public Transaction create()
    {
        return null;
    }

    @Override
    public List<Transaction> get(int id, int month, int year)
    {
        // If someday we resolve to implement a real API we can change to use a Database instead of a mock
        return transactionMock.generateTransactions(id, month, year);
    }

    @Override
    public Transaction update()
    {
        return null;
    }

    @Override
    public void delete()
    {
    }
}
