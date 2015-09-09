package com.twu.biblioteca;

import java.util.Date;
import java.util.HashMap;

public class BibilioticaApplication {
    private BookLibrary libraryData;
    private ConsoleDisplay display;

    public void start() {
        initiateSession();
        IController controller;

        controller = new Controller(display, new WelcomeScreen(), libraryData);
        while (true) {
            controller = controller.executeAction();
        }
    }

    private void initiateSession() {
        display = new ConsoleDisplay(System.in, System.out);

        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author1", new Date());
        String bookName1 = "name1";
        BookDetails bookDetails2 = new BookDetails("author2", new Date());
        String bookName2 = "name2";

        bookList.put(bookName1, bookDetails1);
        bookList.put(bookName2, bookDetails2);
    }
}
