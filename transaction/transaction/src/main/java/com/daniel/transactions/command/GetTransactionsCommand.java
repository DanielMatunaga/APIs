package com.daniel.transactions.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.daniel.transactions.dao.TransactionDAO;
import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.requestHelper.RequestContext;

/**
 * Command that will execute a get transaction.
 */
@Component
public class GetTransactionsCommand implements Command<Transaction>
{
    @Autowired
    private TransactionDAO transactionDao;

    @Override
    public List<Transaction> execute(RequestContext requestContext) throws InvalidRequestException
    {
        int id = requestContext.getRequestPathVariables("id");
        int month = requestContext.getRequestPathVariables("month");
        int year = requestContext.getRequestPathVariables("year");

        return transactionDao.get(id, month, year);
    }
}
