package com.twu.biblioteca;

import java.util.HashMap;

public class BookLibrary {
    private HashMap<String, BookDetails> availableBooks;
    private HashMap<String, BookDetails> checked_outBooks;

    public BookLibrary(HashMap<String, BookDetails> availableBooks, HashMap<String, BookDetails> checked_outBooks) {
        this.availableBooks = availableBooks;
        this.checked_outBooks = checked_outBooks;
    }

    public boolean isBookAvailableForCheckOut(String bookName) {
        return availableBooks.containsKey(bookName);
    }

    public void checkoutBook(String bookName) {
        BookDetails bookDetails = availableBooks.get(bookName);
        checked_outBooks.put(bookName, bookDetails);
        availableBooks.remove(bookName);
    }

    @Override
    public String toString() {
        String output = "";
        for (String bookName: availableBooks.keySet())
            output += bookName + " "+availableBooks.get(bookName).toString();
        return output;
    }

    public boolean isBookReturnable(String bookName) {
        return checked_outBooks.containsKey(bookName);
    }

    public void returnBook(String bookName) {
        BookDetails bookDetails = checked_outBooks.get(bookName);
        availableBooks.put(bookName, bookDetails);
        checked_outBooks.remove(bookName);

    }
}
