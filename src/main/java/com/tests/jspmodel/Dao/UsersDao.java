/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests.jspmodel.Dao;

import com.tests.jspmodel.Dao.Service.UsersDaoService;
import com.tests.jsplogin.model.Users;

/**
 *
 * @author Rohit
 */
public class UsersDao {

    public Users getUser(String uid) {
        Users u = new Users();
        UsersDaoService uds = new UsersDaoService();
        u = uds.getUser(uid);

        return u;
    }
    
    public Users addUser(Users u) {
        
        UsersDaoService uds = new UsersDaoService();
        u = uds.addUser(u);

        return u;
    }

}
