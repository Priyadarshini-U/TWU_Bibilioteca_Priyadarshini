package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeScreenTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        WelcomeScreen screen = new WelcomeScreen();
        assertEquals(screen.message(), "welcome to Bibilioteca");
    }

    @Test
    public void shouldReturnWelcomeMessageOnToString() {
        WelcomeScreen screen = new WelcomeScreen();
        assertEquals(screen.toString(), "welcome to Bibilioteca");
    }
}