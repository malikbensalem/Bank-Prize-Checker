package com.qa.utils.exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String exception){
        super("Account Number supplied does not exist. Account Number: " + exception);
    }

}