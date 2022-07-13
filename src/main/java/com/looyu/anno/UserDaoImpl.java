package com.looyu.anno;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    // 切入点
    @Override
    public void add() {
        System.out.println("add User");
    }

    @Override
    public void delete() {
        System.out.println("delete user");
    }
}
