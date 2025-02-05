package com.gamingstore.classes;

public class CurrentUser {
    public static String currentUser;
    public static void setCurrentUser(String username) {
        currentUser = username;
    }
    public static String getCurrentUser() {
        return currentUser;
    }
}
