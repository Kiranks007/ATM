package com.SBI.ATM.service;

import com.SBI.ATM.entity.Account;
import com.SBI.ATM.repository.AccountRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService {
    @Autowired
    private AccountRepo repo;

    //creating new account--kiran(12/02/2026)
    public String createAccount(Account acc)
    {
        acc.setBalance(0.0);
        repo.save(acc);
        log.info("Account created successfully");
        return "Account created successfully";
    }

    //depositing amount
    public String Deposit(Long id, double depamount)
    {
        Account acc = repo.findById(id).get();
        acc.setBalance(acc.getBalance() + depamount);
        repo.save(acc);
        log.info("Account deposited successfully");
        return "Credited"+depamount+"successfully";
    }
    //transferring amount from one account to another account
    public String Transfer(Long fromId, Long toId,  double tamount)
    {
        Account fromAcc = repo.findById(fromId).get();
        Account toAcc = repo.findById(toId).get();

        if (fromAcc.getBalance() <= tamount)
        {
            return "Insufficient Balance";

        }
        fromAcc.setBalance(fromAcc.getBalance() - tamount);
        toAcc.setBalance(toAcc.getBalance() + tamount);
        repo.save(fromAcc);
        repo.save(toAcc);
        log.info("Account transferred successfully");
        return "Transferred successfully";
    }

    //check balance
    public Double checkBalance(Long id)
    {
        log.info("Checking balance successfully");
        return repo.findById(id).get().getBalance();
    }
}
