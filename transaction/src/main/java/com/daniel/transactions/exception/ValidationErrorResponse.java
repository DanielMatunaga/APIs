package com.daniel.transactions.exception;

import org.springframework.http.HttpStatus;

/**
 * Error response.
 */
public class ValidationErrorResponse
{
    /**
     * The http status of the error.
     */
    private HttpStatus status;

    /**
     * The time stamp of when the error was thrown.
     */
    private long timeStamp;

    /**
     * The message of the error.
     */
    private String message;

    public ValidationErrorResponse(HttpStatus status, long timeStamp, String message)
    {
        this.status = status;
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public HttpStatus getStatus()
    {
        return status;
    }

    public void setStatus(HttpStatus status)
    {
        this.status = status;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
