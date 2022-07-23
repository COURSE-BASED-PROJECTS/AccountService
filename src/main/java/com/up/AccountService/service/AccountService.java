package com.up.AccountService.service;

import com.up.AccountService.model.Account;
import com.up.AccountService.repository.AccountRepository;
import com.up.AccountService.util.BCryptEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    private BCryptEncoder encoder = new BCryptEncoder();

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account addNew(Account acc) {
        return accountRepository.save(acc);
    }

    public Account update(Account acc) {
        return accountRepository.save(acc);
    }

    public Optional<Account> findByAccountId(Integer accId) {
        return accountRepository.findById(accId);
    }


    public boolean validUser(String username, String password) {
        Account user = getAccountByUsername(username);

        if (user != null && BCrypt.checkpw(password, user.getPassword())) {
            return true;
        }
        return false;
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    public Account registerAccount(Account account) throws Exception {
        if (getAccountByUsername(account.getUsername()) != null) {
            throw new Exception("Already have this user!");
        }

        account.password = encoder.passwordEncoder().encode(account.getPassword());
        if (account.isLocked == null) account.isLocked = false;

        return accountRepository.save(account);

    }
}
