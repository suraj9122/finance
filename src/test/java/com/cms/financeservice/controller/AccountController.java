package com.cms.financeservice.controller;

import com.cms.financeservice.constant.Endpoint;
import com.cms.financeservice.domain.Account;
import com.cms.financeservice.service.AccountServiceIfc;
import com.cms.financeservice.service.InvoiceServiceIfc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = Endpoint.ROOT_API_V1)
public class AccountController {

	private AccountServiceIfc accountServiceIfc;

	AccountController(AccountServiceIfc accountServiceIfc, InvoiceServiceIfc invoiceServiceIfc) {
		this.accountServiceIfc = accountServiceIfc;
	}

	@PostMapping(Endpoint.ACCOUNT_CREATE_OR_GETS)
	public @ResponseBody ResponseEntity<Map> createFinanceAccount(@RequestBody Account account) {
		accountServiceIfc.createAccount(account);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@GetMapping(Endpoint.ACCOUNT_CREATE_OR_GETS)
	public @ResponseBody ResponseEntity<List<Account>> getFinanceAccount() {
		List<Account> accounts = accountServiceIfc.getAccounts();
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}

	@GetMapping(Endpoint.ACCOUNT_CREATE_OR_GETS + "/{student_id}")
	public @ResponseBody ResponseEntity<Account> getAccountByStudentId(@PathVariable String student_id) {
		Account accountByStudentId = accountServiceIfc.getAccountByStudentId(Long.valueOf(student_id));
		return ResponseEntity.status(HttpStatus.OK).body(accountByStudentId);
	}

	@DeleteMapping(Endpoint.ACCOUNT_CREATE_OR_GETS + "/{student_id}")
	public @ResponseBody ResponseEntity<Account> deleteAccount(@PathVariable String student_id) {
		accountServiceIfc.deleteAccount(Long.valueOf(student_id));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
