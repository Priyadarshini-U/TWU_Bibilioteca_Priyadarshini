package com.twu.biblioteca;

import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class CatalogTest {

    @Test
    public void shouldAddBookToList() {
        Catalog catalog = new Catalog();

        Book book = new Book("Anna kariena","Tolstoy",new Date());
        catalog.addBook(book);

        assertTrue(catalog.listBooks().contains(book));
    }

    @Test
    public void shouldContainAllBooksAddedInList() {
        Catalog catalog = new Catalog();

        Book book1 = new Book("Anna kariena","Tolstoy",new Date());
        Book book2 = new Book("War and Peace","Tolstoy",new Date());
        catalog.addBook(book1);
        catalog.addBook(book2);

        assertTrue(catalog.listBooks().contains(book2) && catalog.listBooks().contains(book1));
    }

    @Test
    public void shouldContainNotContainExtraBooksAddedInList() {
        Catalog catalog = new Catalog();

        Book book1 = new Book("Anna kariena","Tolstoy",new Date());
        Book book2 = new Book("War and Peace","Tolstoy",new Date());
        catalog.addBook(book1);
        catalog.addBook(book2);

        assertEquals(catalog.listBooks().size(), 2);
    }

    @Test
    public void shouldReturnEmptyStringIfEmpty() {
        Catalog catalog = new Catalog();

        assertEquals(catalog.toString(), "");
    }

    @Test
    public void shouldReturnBookIfCatalogHasSingleBook() {
        Catalog catalog = new Catalog();

        Book book = new Book("Anna kariena","Tolstoy",new Date());
        catalog.addBook(book);

        assertEquals(catalog.toString(), book.toString()+"\n");
    }

    @Test
    public void shouldReturnTrueIfListContainsBook() {
        Catalog catalog = new Catalog();

        Book book = new Book("Anna kariena","Tolstoy",new Date());
        catalog.addBook(book);

        assertTrue(catalog.contains(book));
    }

    @Test
    public void shouldNotReturnTrueIfListContainsBook() {
        Catalog catalog = new Catalog();

        Book book1 = new Book("Anna kariena","Tolstoy",new Date());
        Book book2 = new Book("War and peace","Tolstoy",new Date());
        catalog.addBook(book1);

        assertFalse(catalog.contains(book2));
    }
}