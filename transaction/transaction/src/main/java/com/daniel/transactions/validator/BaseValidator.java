package com.daniel.transactions.validator;

import static com.daniel.transactions.common.CommonExceptionsConstants.NULL_PARAMETER_REQUEST_EXCEPTION_MESSAGE;

import com.daniel.transactions.exception.InvalidRequestException;;

/**
 * Base validator with common validations that can be used.
 */
public abstract class BaseValidator
{
    /**
     * Throws an exception if field is null or zero.
     *
     * @param fieldName The field name that will be validated.
     * @param field The field that will be validated.
     * @throws InvalidRequestException If the field is not valid.
     */
    protected void requiredNotNull(String fieldName, Object field)
            throws InvalidRequestException
    {
        if (field == null || isZero(field))
        {
            throw new InvalidRequestException(NULL_PARAMETER_REQUEST_EXCEPTION_MESSAGE, fieldName);
        }

    }

    private boolean isZero(Object obj)
    {
        return obj instanceof Integer && (Integer) obj == 0;
    }
}
