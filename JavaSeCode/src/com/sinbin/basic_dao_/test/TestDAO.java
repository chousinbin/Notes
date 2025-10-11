package com.sinbin.basic_dao_.test;

import com.sinbin.basic_dao_.dao.AccountDAO;
import com.sinbin.basic_dao_.domain.Account;
import org.junit.Test;

import java.util.List;

public class TestDAO {
    @Test
    public  void testAccountDAO() {
        AccountDAO accountDAO = new AccountDAO();
        // 查询多行多列
        String sql = "select * from account";
        List<Account> accounts = accountDAO.queryMulti(sql, Account.class);
        // iter
        for (Account account : accounts) {
            System.out.println(account);
        }
        // 查询单行多列
        sql = "select * from account where id = ?";
        Account account = accountDAO.querySingle(sql, Account.class, 1);
        System.out.println(account);
        // 单行单列
        sql = "select name from account where id = ?";
        Object obj = accountDAO.queryScalar(sql,1);
        System.out.println(obj);
        // DML 操作
        sql = "insert into account values(null, ?, ?)";
        int res = accountDAO.update(sql, "zxb", 888.8);
        System.out.println(res > 0 ? "success" : "error");
    }
}
