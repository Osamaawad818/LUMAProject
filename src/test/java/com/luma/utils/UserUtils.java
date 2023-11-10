package com.luma.utils;

import com.github.javafaker.Faker;

public class UserUtils {

    public void generateRandomUsers(){
        String randomEmail = new Faker().internet().emailAddress();
        String randomPassword = new Faker().internet().password();

    }
}
