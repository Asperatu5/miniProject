package com.example.zbl.exeption;

public class UserDontExist extends Exception{
    public UserDontExist(String message) {
        super(message);
    }
}
