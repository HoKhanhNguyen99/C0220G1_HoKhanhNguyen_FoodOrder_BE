package com.example.demo.service.Impl;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public void edit(Account account, int id) {
        accountRepository.edit(account.getAccountPassword(), account.getAccountId());
    }

    @Override
    public void addNew(String accountName, String accountPassword, Boolean deleteFlag, Role role) {
        accountRepository.addNew(accountName, accountPassword, true, role);
    }

    @Override
    public void delete(Integer accountId) {
        accountRepository.delete(accountId);
    }
}
