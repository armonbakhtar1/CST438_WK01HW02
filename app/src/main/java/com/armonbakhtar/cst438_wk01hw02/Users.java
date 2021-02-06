package com.armonbakhtar.cst438_wk01hw02;

public class Users {
    private String username;
    private String password;
    private int id;

    public Users(String username, String password, int id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }



    public int getId() {
        return id;
    }


}
