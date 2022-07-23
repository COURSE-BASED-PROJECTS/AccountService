package com.up.AccountService.model;

import javax.persistence.Column;

public class AccountDTO {
    public String username;
    public String password;

    public AccountDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AccountDTO() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
