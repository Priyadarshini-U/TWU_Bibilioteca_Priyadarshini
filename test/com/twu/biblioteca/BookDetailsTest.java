package com.twu.biblioteca;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class BookDetailsTest {

    @Test
    public void shouldReturnConcatenatedStringOfBook() {
        String name = "abc";
        String author = "def";
        Date yearPublished = new Date();
        assertEquals(new BookDetails(author, yearPublished).toString(), author + " " + "2015");
    }
}