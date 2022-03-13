/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tests.jsplogin.model;

/**
 *
 * @author Rohit
 */
public class Users {

    private String uid;
    private String uname;
    private String email;
    private String password;

    public String toString() {
        return "Users{" + "uid=" + uid + ", uname=" + uname + ", email=" + email + ", password=" + password + '}';
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
