//**********************************************************************
// Copyright (c) 2020 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.daniel.transactions.mock;

import java.util.List;

import com.daniel.transactions.entity.Transaction;

/**
 * Service to generate transactions.
 */
public interface TransactionMock {
	/**
	 * Generates transactions based on parameters passed.
	 *
	 * @param id    The id of the user.
	 * @param month The month these transactions are in.
	 * @param year  The year these transactions are in.
	 * @return List<{@Link Transaction}> Returns a list of transactions based on
	 *         parameters passed.
	 */
	List<Transaction> generateTransactions(int id, int year, int month);
}
