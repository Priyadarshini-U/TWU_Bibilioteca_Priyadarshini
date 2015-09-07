package com.twu.biblioteca;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnConcatenatedStringOfBook() {
        String name = "abc";
        String author = "def";
        Date yearPublished = new Date();
        assertEquals(new Book(name, author, yearPublished).toString(), name + " " + author + " " + "2015");
    }
}