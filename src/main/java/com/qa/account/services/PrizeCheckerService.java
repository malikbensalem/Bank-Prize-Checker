package com.qa.account.services;

import org.springframework.stereotype.Service;

@Service
public class PrizeCheckerService {
	public double prizeCheck(String accountNumber) {//where does this go
		if (accountNumber.startsWith("b")) {
			return 5 *(((accountNumber.length()/2)-2)*10);			
		}
		else if (accountNumber.startsWith("c")) {
			if (accountNumber.length()==6) {
				return 100;
			}
			else if(accountNumber.length()==8) {
				return 750;
			}
			return 10000;
		}
		return 0;		
	}
}
