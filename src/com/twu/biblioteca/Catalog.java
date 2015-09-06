package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
    private List<Book> list;

    public Catalog() {
        list = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        this.list.add(book);
    }

    public List<Book> listBooks() {
        return list;
    }

    @Override
    public String toString() {
        String out ="";
        for(Book book: list)
            out = out + book.toString()+"\n";
        return out;
    }
}
