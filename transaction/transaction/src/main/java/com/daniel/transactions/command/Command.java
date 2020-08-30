package com.daniel.transactions.command;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniel.transactions.entity.Entity;
import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.requestHelper.RequestContext;

/**
 * Generic class of commands.
 */
@Service
public interface Command<T extends Entity>
{
    /**
     * Executes the commands.
     *
     * @return List<{@link Entity}> Returns a list of entities after the execution of the command.
     * @throws InvalidRequestException If a request is not valid.
     */
    List<T> execute(RequestContext requestContext) throws InvalidRequestException;
}
