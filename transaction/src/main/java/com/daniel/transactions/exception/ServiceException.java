package com.daniel.transactions.exception;

import org.springframework.http.HttpStatus;

/**
 * Exception that can be thrown by the service.
 */
public class ServiceException extends Exception
{
    private static final long serialVersionUID = 1L;

    private long timeStamp;

    private HttpStatus httpStatus;

    public ServiceException(HttpStatus httpStatus, long timeStamp, String message)
    {
        super(message);
        this.timeStamp = timeStamp;
        this.httpStatus = httpStatus;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }

}
