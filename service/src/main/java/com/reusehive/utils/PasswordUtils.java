package com.reusehive.utils;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static Boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
