package com.daniel.transactions.validator;

import org.springframework.stereotype.Service;

import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.requestHelper.RequestContext;

/**
 * Generic class of validators.
 */
@Service
public interface Validator
{
    /**
     * Validates fields of a command.
     *
     * @throws InvalidRequestException If fields are not valid.
     */
    void validate(RequestContext requestContext) throws InvalidRequestException;
}
