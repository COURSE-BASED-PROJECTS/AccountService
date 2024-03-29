package com.up.AccountService.repository;

import com.up.AccountService.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsername(String username);
    @Query(value = "SELECT * FROM accounts acc where acc.phonenumber = :phoneNumber", nativeQuery = true)
    Account findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
