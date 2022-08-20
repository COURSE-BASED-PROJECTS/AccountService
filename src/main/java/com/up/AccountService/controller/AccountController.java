package com.up.AccountService.controller;

import com.up.AccountService.model.Account;
import com.up.AccountService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/name/{phoneNumber}")
    public ResponseEntity<String> getName(@PathVariable("phoneNumber") String phoneNumber) {
        return new ResponseEntity<>(accountService.findNameByPhoneNumber(phoneNumber), HttpStatus.OK);
    }
}
