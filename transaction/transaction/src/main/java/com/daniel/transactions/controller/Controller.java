package com.daniel.transactions.controller;

import static com.daniel.transactions.common.CommonConstants.GET_TRANSACTIONS_COMMAND;
import static com.daniel.transactions.common.CommonConstants.GET_TRANSACTIONS_VALIDATOR;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.transactions.command.Command;
import com.daniel.transactions.entity.Transaction;
import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.requestHelper.RequestContextImpl;
import com.daniel.transactions.validator.Validator;

/**
 * The rest controller that will handle all rest endpoints.
 */
@RestController
public class Controller
{
    @Autowired
    private Map<String, Command<Transaction>> transactionsCommands;

    @Autowired
    private Map<String, Validator> transactionsValidators;

    /**
     * Returns an list of transactions.
     *
     * @param id The id of the user.
     * @param year The year of the transaction.
     * @param month The month of the transaction
     * @return List<{@link Transaction} Returns a list of the transactions in the specific year and month of that user.
     * @throws InvalidRequestException If the request is wrong.
     */
    @GetMapping ("/{id}/transacoes/{year}/{month}")
    public ResponseEntity<List<Transaction>> getTransacoes(@PathVariable int id, @PathVariable int year, @PathVariable int month)
            throws InvalidRequestException
    {
        //As we are doing a get we only need to set request parameters. If we do a post or update we could create a method in
        //requestContext to set the body with an Entity as well.
        RequestContextImpl requestContext = new RequestContextImpl();
        requestContext.setRequestPathVariable("id", id);
        requestContext.setRequestPathVariable("year", year);
        requestContext.setRequestPathVariable("month", month);

        Validator getTransactionsValidator = transactionsValidators.get(GET_TRANSACTIONS_VALIDATOR);
        getTransactionsValidator.validate(requestContext);

        Command<Transaction> getTransactionsCommand = transactionsCommands.get(GET_TRANSACTIONS_COMMAND);
        List<Transaction> response = getTransactionsCommand.execute(requestContext);

        return ResponseEntity.ok().body(response);
    }
}
