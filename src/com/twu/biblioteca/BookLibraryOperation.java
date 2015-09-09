package com.twu.biblioteca;

public class BookLibraryOperation {
    private ConsoleDisplay display;
    private BookLibrary libraryData;

    public BookLibraryOperation(ConsoleDisplay display, BookLibrary libraryData) {
        this.display = display;
        this.libraryData = libraryData;
    }


    public BookLibrary executeCheckout() {
        String name = display.getString();
        if(libraryData.isBookAvailableForCheckOut(name)) {
            libraryData.checkoutBook(name);
            display.putOutput("Checkout succesful");
        }
        else
            display.putOutput("Checkout NOT succesful");
        return libraryData;
    }

    public BookLibrary executeReturn() {
        String name = display.getString();
        if(libraryData.isBookReturnable(name)) {
            libraryData.returnBook(name);
            display.putOutput("Return succesful");
        }
        else
            display.putOutput("Return NOT succesful");
        return libraryData;
    }
}
