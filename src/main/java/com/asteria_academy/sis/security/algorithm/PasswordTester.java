package com.asteria_academy.sis.security.algorithm;

public class PasswordTester {
    public static void main(String[] args) {
        String password = "password";

        PasswordArgon2SpringSecurity security = new PasswordArgon2SpringSecurity();
        String salt = security.generateSalt();
        String hash = security.encryptPassword(password, salt);

        String testPassword = "password";
        boolean result = security.matchPasswords(salt, testPassword, hash);
        if (result) {
            System.out.println("Password match: " + result);
        } else {
            System.out.println("Password does not match: " + result);
        }
    }
}
