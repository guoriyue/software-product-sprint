package com.google.sps.servlets;

public class Reply {
    private final boolean isLoggedIn;
    private final String authURL;

    public Reply(boolean isLoggedIn, String authURL) {
        this.isLoggedIn = isLoggedIn;
        this.authURL = authURL;
    }
}
