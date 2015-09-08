package com.twu.biblioteca;

import java.util.List;

public class BookLibrary {
    private List<Book> availableBooks;
    private List<Book> checked_outBooks;

    public BookLibrary(List<Book> availableBooks, List<Book> checked_outBooks) {
        this.availableBooks = availableBooks;
        this.checked_outBooks = checked_outBooks;
    }

    public boolean isBookAvailableForCheckOut(Book book) {
        return availableBooks.contains(book);
    }

    public void checkoutBook(Book book) {
        checked_outBooks.add(book);
        availableBooks.remove(availableBooks.indexOf(book));
    }
}
