package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Modifying
    @Query(value = "insert into account(account_name,account_password,deleteFlag,role_id) values (?1,?2,?3,?4,?5)", nativeQuery = true)
    void addNew(String accountName, String accountPassword, Boolean deleteFlag, Role role);

    @Query(value = "select * from account", nativeQuery = true)
    List<Account> findAll();

    @Query(value = "select * from account where account_id = ?1", nativeQuery = true)
    Account findAccountById(int id);

    @Modifying
    @Query(value = "update account set account_password = ?1 where account_id = ?2", nativeQuery = true)
    void edit(String accountPassword, int id);

    @Modifying
    @Query(value = "update account set delete_flag = true where account_id =?1", nativeQuery = true)
    void delete(int id);
}
