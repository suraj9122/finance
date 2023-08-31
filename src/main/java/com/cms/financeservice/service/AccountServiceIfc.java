package com.cms.financeservice.service;

import com.cms.financeservice.domain.Account;

import java.util.List;

public interface AccountServiceIfc {

	void createAccount(Account account);

	Account getAccountByStudentId(long studentId);

	List<Account> getAccounts();

	void deleteAccount(long studentId);
	
}
