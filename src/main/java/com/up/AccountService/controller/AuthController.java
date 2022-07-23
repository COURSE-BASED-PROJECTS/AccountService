package com.up.AccountService.controller;

import com.up.AccountService.model.Account;
import com.up.AccountService.model.AccountDTO;
import com.up.AccountService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AccountService accountService;

    @Autowired
    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) {
        try {
            Account registedAccount = accountService.registerAccount(account);
            System.out.println("Info saved...");

            return new ResponseEntity<>("Registered user \"" + registedAccount.getUsername() + "\"!", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Account> login(@RequestBody AccountDTO account) {
        if (accountService.validUser(account.getUsername(), account.getPassword())) {
            return new ResponseEntity<>(accountService.getAccountByUsername(account.getUsername()), HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

}
