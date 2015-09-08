package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookLibraryTest {

    @Test
    public void shouldCheckIfBookIsInAvailableBookList() {
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book("name", "author", new Date());
        bookList.add(book);
        BookLibrary bookLibrary = new BookLibrary(bookList, null);

        assertTrue(bookLibrary.isBookAvailableForCheckOut(book));
    }

    @Test
    public void shouldCheckIfBookIsNotInAvailableBookList() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("name", "author", new Date());
        Book book2 = new Book("name", "author", new Date());
        bookList.add(book1);
        BookLibrary bookLibrary = new BookLibrary(bookList, null);

        assertFalse(bookLibrary.isBookAvailableForCheckOut(book2));
    }

    @Test
    public void shouldNotAllowCheckOutOfAlreadyCheckedOutBooks() {
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book("name", "author", new Date());
        bookList.add(book1);
        BookLibrary bookLibrary = new BookLibrary(bookList, new ArrayList<Book>());

        bookLibrary.checkoutBook(book1);

        assertFalse(bookLibrary.isBookAvailableForCheckOut(book1));
    }
}