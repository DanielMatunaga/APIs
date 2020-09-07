package com.daniel.transactions.mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.daniel.transactions.entity.Transaction;

/**
 * Simulator of a database.
 */
@Component
public class TransactionMockImpl implements TransactionMock {

	// This is a seed that changes everytime the application goes up.
	// We are going to have the same seed until we stop the application.
	// When we start a new application the seed will change again.
	private static final long randomInitialSeed = System.currentTimeMillis();

	@Override
	public List<Transaction> generateTransactions(int id, int year, int month) {
		List<Transaction> transactions = new ArrayList<>();

		long seed = randomInitialSeed * id * month * year;
		Random random = new Random(seed);

		int numberOfTransactions = generateRandomInt(random, 10, 1);
		boolean hasDuplicated = false;

		for (int i = 0; i < numberOfTransactions; i++) {
			Transaction transaction = new Transaction();
			transaction.setDescricao(generateDescription(random));
			transaction.setData(getDateTimeStamp(random, year, month));
			transaction.setValor(generateValue(random));

			// If we have luck of having a duplicated transaction it will be catched here.
			if (checkDuplicated(transactions, transaction)) {
				transaction.setDuplicated(true);
				hasDuplicated = true;
			}

			transactions.add(transaction);
		}

		// This ensures that we always have at least one duplicated transaction per
		// month.
		if (!hasDuplicated) {
			generateDuplicated(random, transactions);
		}

		return transactions;
	}

	private int generateRandomInt(Random random, int max, int min) {
		return random.nextInt((max - min) + 1) + min;
	}

	private void generateDuplicated(Random random, List<Transaction> transactions) {
		int randomPosition = generateRandomInt(random, transactions.size() - 1, 0);

		Transaction randomExistentTransaction = transactions.get(randomPosition);

		Transaction duplicatedTransaction = new Transaction();
		duplicatedTransaction.setData(randomExistentTransaction.getData());
		duplicatedTransaction.setDescricao(randomExistentTransaction.getDescricao());
		duplicatedTransaction.setValor(randomExistentTransaction.getValor());
		duplicatedTransaction.setDuplicated(true);
		transactions.add(duplicatedTransaction);
	}

	private boolean checkDuplicated(List<Transaction> transactions, Transaction transaction) {
		return transactions.stream().anyMatch(t -> t.equals(transaction));
	}

	private int generateValue(Random random) {
		return generateRandomInt(random, 9999999, -9999999);
	}

	private long getDateTimeStamp(Random random, int year, int month) {
		int numberOfDays;

		Calendar calendar = Calendar.getInstance();
		// Calendar uses january as 0 so we need to add one to get the right month
		// number.
		int currentMonth = calendar.get(Calendar.MONTH) + 1;
		// If we want to get transactions from the current month it cannot generate
		// transactions in the future.
		if (month == currentMonth) {
			numberOfDays = calendar.get(Calendar.DAY_OF_MONTH);
		} else {
			// Calendar uses january as 0 so we need to subtract one to use the right month
			// number.
			calendar = new GregorianCalendar(year, month - 1, 1);
			numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		int randomDate = generateRandomInt(random, numberOfDays, 1);
		calendar = new GregorianCalendar(year, month - 1, randomDate);
		return calendar.getTimeInMillis();
	}

	private String generateDescription(Random random) {
		int numberOfcharacters = generateRandomInt(random, 60, 10);

		StringBuilder description = new StringBuilder();

		appendSyllables(random, numberOfcharacters, description);

		insertSpaces(random, description);

		return description.toString();
	}

	private void insertSpaces(Random random, StringBuilder description) {

		int numberOfSpaces = generateRandomInt(random, description.length() / 3, 0);

		for (int i = 0; i < numberOfSpaces; i++) {
			int randomPosition = generateRandomInt(random, description.length() - 1, 1) - 1;
			// if it is an even number add one to always get odd positions and not leave
			// consonants alone
			if (randomPosition % 2 == 0) {
				randomPosition++;
			}
			description.setCharAt(randomPosition, ' ');
		}
	}

	private void appendSyllables(Random random, int numberOfcharacters, StringBuilder description) {
		// Each syllable has two letters so we have to divide the number of characters
		// by 2.
		// Here we are not concerning if it is a odd number, because the minimal
		// restrition is a even number.
		for (int i = 0; i < numberOfcharacters / 2; i++) {
			char vowel = getRandomVowel(random);
			char consonant = getRandomConsonant(random);

			StringBuilder syllables = new StringBuilder();
			syllables.append(vowel);
			syllables.append(consonant);

			description.append(syllables);
		}
	}

	private char getRandomVowel(Random random) {
		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };

		int positionOfVowel = generateRandomInt(random, 4, 0);
		return vowels[positionOfVowel];
	}

	private char getRandomConsonant(Random random) {
		char randomChar;

		do {
			randomChar = (char) (generateRandomInt(random, 122, 97));
		} while (randomChar == 'a' || randomChar == 'e' || randomChar == 'i' || randomChar == 'o' || randomChar == 'u');

		return randomChar;
	}
}
