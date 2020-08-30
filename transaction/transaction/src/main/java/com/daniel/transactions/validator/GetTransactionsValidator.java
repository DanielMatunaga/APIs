package com.daniel.transactions.validator;

import static com.daniel.transactions.common.CommonExceptionsConstants.RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.daniel.transactions.exception.InvalidRequestException;
import com.daniel.transactions.requestHelper.RequestContext;

/**
 * Validator of path parameters of a transaction.
 */
@Component
public class GetTransactionsValidator extends BaseValidator implements Validator
{
    @Override
    public void validate(RequestContext requestContext) throws InvalidRequestException
    {
        int id = requestContext.getRequestPathVariables("id");
        int month = requestContext.getRequestPathVariables("month");
        int year = requestContext.getRequestPathVariables("year");

        requiredNotNull("id", id);
        requiredNotNull("mes", month);
        requiredNotNull("ano", year);

        if (id < 1000 || id > 100000000)
        {
            throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "id");
        }

        if (month > 12 || month < 0)
        {
            throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "mes");
        }

        if (year > 9999 || year < 0)
        {
            throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "ano");
        }

        Calendar calendar = Calendar.getInstance();
        //Calendar uses january as 0 so we need to add one to get the right month number.
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        int currentYear = calendar.get(Calendar.YEAR);

        if (year > currentYear)
        {
            throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "ano");
        }
        else if (year == currentYear && month > currentMonth)
        {
            throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "mes");
        }
    }
}
