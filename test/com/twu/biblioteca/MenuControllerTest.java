package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuControllerTest {

    @Test
    public void shouldPrintCurrentObject() {
        Menu menu = new Menu();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.in, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu, null);
        controller.executeAction();

        assertTrue(outContent.toString().contains("[1. List Books, 2. quit, 3. CheckOut Book, 4. return Book]"));
    }

    @Test
    public void shouldGetChoiceAndReturnControllerIfChoiceIsOne() {
        Menu menu = new Menu();

        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, System.out);
        MenuController controller = new MenuController(consoleDisplay, menu, null);
        IController result = controller.executeAction();

        assertEquals(result.getClass(), Controller.class);
    }

    @Test
    public void shouldGetChoiceAndReturnControllerWithLibraryDataIfChoiceIsOne() {
        Menu menu = new Menu();

        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        BookLibrary bookLibrary = new BookLibrary(new HashMap<String, BookDetails>(), bookList);
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu, bookLibrary);
        IController result = controller.executeAction();
        result.executeAction();
        System.setIn(System.in);

        assertTrue(outContent.toString().contains(bookLibrary.toString()));
    }

    @Test
    public void shouldCheckOutBookIfChoiceIsThree() {
        Menu menu = new Menu();

        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        BookLibrary bookLibrary = new BookLibrary(new HashMap<String, BookDetails>(), bookList);
        String input = "3";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(inContent, new PrintStream(outContent));
        MenuController controller = new MenuController(consoleDisplay, menu, bookLibrary);
        IController result = controller.executeAction();
        result.executeAction();

        assertFalse(bookLibrary.isBookAvailableForCheckOut(bookName1));
    }
}