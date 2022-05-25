package com.example.asm4.model;

import com.example.asm4.entity.Account;

import java.util.List;

public interface AccoutModel {
    boolean save(Account account);
    boolean update(int id, Account account);
    boolean delete(int id);
    Account findById(int id);
    List<Account> findAll();
}
