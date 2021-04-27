package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findAccountById(int id);

    void edit(Account account, int id);

    void addNew(String accountName, String accountPassword, Boolean deleteFlag, Role role);

    void delete(Integer accountId);
}
