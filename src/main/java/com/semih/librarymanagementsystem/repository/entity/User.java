package com.semih.librarymanagementsystem.repository.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class User extends StateInfo{
    private String password;
}
