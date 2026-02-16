package com.SBI.ATM.repository;

import com.SBI.ATM.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account,Long> {
}
