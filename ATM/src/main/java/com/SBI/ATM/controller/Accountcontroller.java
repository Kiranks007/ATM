package com.SBI.ATM.controller;

import com.SBI.ATM.entity.Account;
import com.SBI.ATM.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atm")
public class Accountcontroller {

    @Autowired
    private AccountService service;

    //create new account API
    @PostMapping("/create")
    public String createAccount(@RequestBody Account acc)
    {
        return service.createAccount(acc);
    }

    //deposit API(http://localhost:8080/atm/deposit/4/500.0)
    @PutMapping("/deposit/{id}/{depAmount}")
    public String Deposit(@PathVariable Long id, @PathVariable double depAmount)
    {
        return service.Deposit(id, depAmount);
    }

    //transfer API(http://localhost:8080/atm/transfer/4/5/500.0)
    @PutMapping("/transfer/{fromId}/{toId}/{tAmount}")
    public String Transfer(@PathVariable Long fromId, @PathVariable Long toId,  @PathVariable double tAmount)
    {
        return service.Transfer(fromId, toId, tAmount);
    }

    //to check balance
    @GetMapping("/check-Balance/{id}")
    public Double checkBalance(@PathVariable Long id)
        {
        return service.checkBalance(id);
        }


}
