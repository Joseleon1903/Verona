package com.example.rest.swagger.verona.repository;

import com.example.rest.swagger.verona.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByAccountId(int accountId);

    Account findByAccountNumber(String accountNumber);
}
