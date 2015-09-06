package com.twu.biblioteca;

public class WelcomeScreen {

    public final String welcomeMessage = "welcome to Bibilioteca";

    public String message() {
        return welcomeMessage;
    }

    @Override
    public String toString() {
        return message();
    }

}
