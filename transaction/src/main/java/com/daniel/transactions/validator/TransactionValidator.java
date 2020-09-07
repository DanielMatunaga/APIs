package com.daniel.transactions.validator;

import static com.daniel.transactions.common.CommonExceptionsConstants.NULL_PARAMETER_REQUEST_EXCEPTION_MESSAGE;
import static com.daniel.transactions.common.CommonExceptionsConstants.RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.daniel.transactions.exception.InvalidRequestException;

/**
 * Validator of path parameters of a transaction.
 */
@Component
public class TransactionValidator {

	public void validate(int id, int year, int month) throws InvalidRequestException {

		requiredNotNull("id", id);
		requiredNotNull("mes", month);
		requiredNotNull("ano", year);

		validateId(id);
		validateMonth(month);
		validateYear(year);

		validatePastDate(year, month);
	}

	private void validatePastDate(int year, int month) throws InvalidRequestException {
		Calendar calendar = Calendar.getInstance();
		// Calendar uses january as 0 so we need to add one to get the right month
		// number.
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		int currentYear = calendar.get(Calendar.YEAR);

		if (year > currentYear) {
			throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "ano");
		} else if (year == currentYear && month > currentMonth) {
			throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "mes");
		}
	}

	private void validateYear(int year) throws InvalidRequestException {
		if (year > 9999 || year < 0) {
			throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "ano");
		}
	}

	private void validateMonth(int month) throws InvalidRequestException {
		if (month > 12 || month < 0) {
			throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "mes");
		}
	}

	private void validateId(int id) throws InvalidRequestException {
		if (id < 1000 || id > 100000000) {
			throw new InvalidRequestException(RANGE_PARAMETER_REQUEST_EXCEPTION_MESSAGE, "id");
		}
	}

	private void requiredNotNull(String fieldName, Object field) throws InvalidRequestException {
		if (field == null || isZero(field)) {
			throw new InvalidRequestException(NULL_PARAMETER_REQUEST_EXCEPTION_MESSAGE, fieldName);
		}

	}

	private boolean isZero(Object obj) {
		return obj instanceof Integer && (Integer) obj == 0;
	}

}
