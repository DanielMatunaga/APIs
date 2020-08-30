package com.daniel.transactions.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception that can be thrown by an invalid request.
 */
public class InvalidRequestException extends ServiceException
{
    private static final long serialVersionUID = 1L;

    private String parameter;

    public InvalidRequestException(String message, String parameter)
    {
        super(HttpStatus.BAD_REQUEST, System.currentTimeMillis(), message);
        this.parameter = parameter;
    }

    public String getParameter()
    {
        return parameter;
    }
}
