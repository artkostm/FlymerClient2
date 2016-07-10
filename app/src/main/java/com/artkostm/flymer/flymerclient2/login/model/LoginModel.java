package com.artkostm.flymer.flymerclient2.login.model;

/**
 * Created by arttsiom.chuiko on 10/07/16.
 */
public class LoginModel {
    private final String email;
    private final String password;

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
