package com.up.AccountService.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    public Integer account_id;

    @Column(name = "username")
    public String username;

    @Column(name = "name")
    public String name;

    @Column(name = "password")
    public String password;

    @Column(name = "role")
    public String role;

    @Column(name = "phonenumber")
    public String phoneNumber;

    @Column(name = "avatar")
    public String avatar;

    @Column(name = "address")
    public String address;

    @Column(name = "is_locked")
    public Boolean isLocked;
    public Account() {
    }

    public Account(Integer account_id, String username, String name, String password, String role, String phoneNumber, String avatar, String address, Boolean isLocked) {
        this.account_id = account_id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.avatar = avatar;
        this.address = address;
        this.isLocked = isLocked;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getLocked() {
        return isLocked;
    }
}
