package com.qa.account.services;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AccountNumberGeneratorService {
	public String generatorAccountNumber() {
		String accountNumber = "";
		accountNumber += (char) ThreadLocalRandom.current().nextInt(97, 101);
		for (int i = 0; i < new int[] { 6, 8, 10 }[new Random().nextInt(3)]; i++) {
			accountNumber += new Random().nextInt(10);
		}
		return accountNumber;
	}
}
