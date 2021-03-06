package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    @NotNull
    @Size(max = 255, min = 1)
//    @Pattern(regexp = "^[a-zA-Z0-9\\,\\.\\-\\_\\@]{1,}$")
    @Column(name = "account_name", nullable = false, unique = true)
    @NotBlank(message = "Tên không được để trống")
    private String accountName;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 255, min = 1)
    @Column(name = "account_password", nullable = false)
    private String accountPassword;

    @Column(name = "delete_flag")
    boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
