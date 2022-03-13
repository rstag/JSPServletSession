/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests.jspmodel.Dao.Service;

import com.tests.dbcon.DBUtils;
import com.tests.jsplogin.model.Users;
import java.sql.ResultSet;
import java.util.Random;

/**
 *
 * @author Rohit
 */
public class UsersDaoService {

    DBUtils db = new DBUtils();

    public Users getUser(String uid) {
        ResultSet rs = null;
        Users u = new Users();
        System.out.println("UDS uid " + uid);
        String sql = "select * from users where uid = '" + uid + "';";
        try {
            rs = db.runSql(sql);
            System.out.println("rs " + rs);
            if (rs.next() == false) {
                System.out.println("rs is empty");
                u.setUid(null);
                return u;
            } else {
                do {
                    u.setUid(rs.getString("uid"));
                    u.setUname(rs.getString("uname"));
                    u.setEmail(rs.getString("email"));
                    u.setPassword(rs.getString("password"));
                    System.out.println("UDS " + u.toString());
                } while (rs.next());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

    public Users addUser(Users u) {
        int res = 0;
        String uid = getnewId();
        System.out.println("UDS uid ** " + uid);
        u.setUid(uid);
        String sql = "insert into users values('" + u.getUid() + "','" + u.getUname() + "','" + u.getEmail() + "','" + u.getPassword() + "');";
        try {
            System.out.println("sql " + sql);
            res = db.insertSql(sql);

        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }

    public String getnewId() {
        String uid = "";
        Random rand = new Random();

        Users u = new Users();
        u.setUid(null);
        do {
            uid = String.valueOf(rand.nextInt(1000));
            u = getUser(uid);

        } while (u.getUid() != null);
        return uid;
    }
}
