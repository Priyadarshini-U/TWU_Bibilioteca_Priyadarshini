package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {

    @Test
    public void shouldPrintCurrentObject() {
        Menu menu = new Menu();

        String input="1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu);
        controller.executeAction();

        assertTrue(outContent.toString().contains("[1. List Books, 2. quit, 3. CheckOut Book]"));
    }

    @Test
    public void shouldReturnCatalogIfChoiceIsOne() {
        Menu menu = new Menu();

        String input="1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, System.out);
        MenuController controller = new MenuController(consoleDisplay, menu);
        IController result = controller.executeAction();
        System.setOut(new PrintStream(outContent));
        result.executeAction();

        assertEquals(outContent.toString(), "");
    }

    @Test
    public void shouldReturnInvalidCommandIfChoiceIsNeitherOneNorTwo() {
        Menu menu = new Menu();

        String input="-1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu);
        IController result = controller.executeAction();
        result.executeAction();

        assertTrue(outContent.toString().contains("Invalid Menu"));
    }
}