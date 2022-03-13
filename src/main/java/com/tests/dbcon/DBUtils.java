/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rohit
 */
public class DBUtils {

    String host = "jdbc:mysql://localhost:3306/";
    String database = "rs";
    String username = "root";
    String password = "rs123";

    public Connection getCon() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(host + database, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public ResultSet runSql(String sql) {
        ResultSet rs = null;
        try {
            // Select operations
            Connection con =getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }

    public int insertSql(String sql) {
        int res = 0;
        try {
            // DML operations - insert
            Connection con =getCon();
            PreparedStatement ps = con.prepareStatement(sql);
            res = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return res;
    }

}
