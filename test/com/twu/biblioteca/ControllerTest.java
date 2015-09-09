package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    @Test
    public void shouldPrintCurrentObject() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);

        Controller controller = new Controller(consoleDisplay, welcomeScreen, null);
        controller.executeAction();

        verify(consoleDisplay).putOutput(welcomeScreen);
    }

    @Test
    public void shouldReturnNewControllerWithMenu() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        String input="1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen, null);
        IController result =  controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains("[1. List Books, 2. quit, 3. CheckOut Book]"));
    }
}