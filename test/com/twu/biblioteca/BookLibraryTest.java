package com.twu.biblioteca;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookLibraryTest {

    @Test
    public void shouldCheckIfBookIsInAvailableBookList() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        String bookName = "name";
        BookDetails bookDetails = new BookDetails("author", new Date());
        bookList.put(bookName, bookDetails);
        BookLibrary bookLibrary = new BookLibrary(bookList, null);

        assertTrue(bookLibrary.isBookAvailableForCheckOut(bookName));
    }

    @Test
    public void shouldCheckIfBookIsNotInAvailableBookList() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        String bookName2 = "name2";
        bookList.put(bookName1, bookDetails1);
        BookLibrary bookLibrary = new BookLibrary(bookList, null);

        assertFalse(bookLibrary.isBookAvailableForCheckOut(bookName2));
    }

    @Test
    public void shouldNotAllowCheckOutOfAlreadyCheckedOutBooks() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        BookLibrary bookLibrary = new BookLibrary(bookList, new HashMap<String, BookDetails>());

        bookLibrary.checkoutBook(bookName1);

        assertFalse(bookLibrary.isBookAvailableForCheckOut(bookName1));
    }

    @Test
    public void shouldCheckIfBookIsReturnable() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        String bookName = "name";
        BookDetails bookDetails = new BookDetails("author", new Date());
        bookList.put(bookName, bookDetails);
        BookLibrary bookLibrary = new BookLibrary(null, bookList);

        assertTrue(bookLibrary.isBookReturnable(bookName));
    }

    @Test
    public void shouldCheckIfBookIsNotReturnable() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        BookLibrary bookLibrary = new BookLibrary(new HashMap<String, BookDetails>(), bookList);

        assertFalse(bookLibrary.toString().contains("name1 author 2015"));
    }

    @Test
    public void shouldNotAllowReturnOfAlreadyReturnedBooks() {
        HashMap<String, BookDetails> bookList = new HashMap<String, BookDetails>();
        BookDetails bookDetails1 = new BookDetails("author", new Date());
        String bookName1 = "name1";
        bookList.put(bookName1, bookDetails1);
        BookLibrary bookLibrary = new BookLibrary(new HashMap<String, BookDetails>(), bookList);
        bookLibrary.returnBook(bookName1);

        assertFalse(bookLibrary.isBookReturnable(bookName1));
    }
}