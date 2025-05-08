package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/create")
	public Account createAcc(@RequestBody Account account) {
		
		return accountService.createAc(account);
	}
	@GetMapping("/accounts")
    public List<String> getAllAccountNumbers() {
        return accountService.getAllAccountNumbers();
    }
	@PostMapping("/deposit/{accountNo}/{amount}")
    public String deposit(@PathVariable("accountNo") String accountNumber, @PathVariable double amount) {
        double newBalance = accountService.deposit(accountNumber, amount);
        return "Deposit successful. New balance: " + newBalance;
    }

    @PostMapping("/withdraw/{accountNo}/{amount}")
    public String withdraw(@PathVariable("accountNo") String accountNumber, @PathVariable double amount) {
        Account account = accountService.AccountByAcNo(accountNumber);
        if (account.getBalance() < amount) {
            return "Withdrawal failed: insufficient balance.";
        }
        double newBalance = accountService.withdraw(accountNumber, amount);
        return "Withdrawal successful. New balance: " + newBalance;
    }
    @GetMapping("/allAccounts")
    public Iterable<Account> getAllAccountsDetails() {
        return accountService. getAllAccountsDetails();
    }

	
	

}