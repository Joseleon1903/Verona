package com.example.rest.swagger.verona.rest;

import com.example.rest.swagger.verona.model.Account;
import com.example.rest.swagger.verona.model.ConsultBalanceResponse;
import com.example.rest.swagger.verona.model.MakeTransactRequest;
import com.example.rest.swagger.verona.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Transaction")
public class TransactionController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/ConsultBalance")
    public ResponseEntity<ConsultBalanceResponse> consultBalance(@RequestParam("idAccount") int idAccount ){
        Account acc = accountRepository.findByAccountId(idAccount);
        ConsultBalanceResponse response = new ConsultBalanceResponse();
        if(acc !=null){
            response.setAccount(acc.getAccountNumber());
            response.setBalance(acc.getBalance());
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/MakeTransaction")
    public ResponseEntity executeTransaction(@RequestBody MakeTransactRequest request){
        Account accDest = accountRepository.findByAccountNumber(request.getDestinationAccount());
        Account accOrigin = accountRepository.findByAccountNumber(request.getOriginAccount());

        if (accDest == null  || accOrigin ==null ) {
            return ResponseEntity.ok().build();
        }

        double result =  accDest.getBalance() + request.getAmount();
        accDest.setBalance(result);

        result =  accOrigin.getBalance() - request.getAmount();
        accOrigin.setBalance(result);

        accountRepository.save(accDest);

        accountRepository.save(accOrigin);

        return ResponseEntity.ok().build();
    }







}
