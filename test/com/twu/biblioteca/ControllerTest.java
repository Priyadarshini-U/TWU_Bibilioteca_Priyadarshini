package com.twu.biblioteca;

import com.apple.eawt.Application;
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

        Controller controller = new Controller(consoleDisplay, welcomeScreen);
        controller.executeAction();

        verify(consoleDisplay).putOutput(welcomeScreen);
    }

    @Test
    public void shouldReturnNewControllerWithMenu() {
        WelcomeScreen welcomeScreen = new WelcomeScreen();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, new PrintStream(outContent));
        Controller controller = new Controller(consoleDisplay, welcomeScreen);
        Controller result =  controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains("[List Books, quit]"));
    }
}