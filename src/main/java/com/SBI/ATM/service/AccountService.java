package com.SBI.ATM.service;

import com.SBI.ATM.entity.Account;
import com.SBI.ATM.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepo repo;

    //creating new account--kiran(12/02/2026)
    public String createAccount(Account acc)
    {
        acc.setBalance(0.0);
        repo.save(acc);
        return "Account created successfully";
    }

    //depositing amount
    public String Deposit(Long id, double depamount)
    {
        Account acc = repo.findById(id).get();
        acc.setBalance(acc.getBalance() + depamount);
        repo.save(acc);
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
        return "Transferred successfully";
    }

    //check balance
    public Double checkBalance(Long id)
    {
        return repo.findById(id).get().getBalance();
    }
}
