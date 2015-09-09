package com.twu.biblioteca;

import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookLibraryOperationTest {

    @Test
    public void shouldCheckIfBookIsAvailableForExecuteCheckout() {
        BookLibrary bookLibrary = mock( BookLibrary.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");

        BookLibraryOperation bookLibraryOperation = new BookLibraryOperation(consoleDisplay, bookLibrary);
        bookLibraryOperation.executeCheckout();

        verify(bookLibrary).isBookAvailableForCheckOut("name1");
    }

    @Test
    public void shouldCheckoutBookIfAvailable() {
        BookLibrary bookLibrary = mock( BookLibrary.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(bookLibrary.isBookAvailableForCheckOut(anyString())).thenReturn(true);

        BookLibraryOperation bookLibraryOperation = new BookLibraryOperation(consoleDisplay, bookLibrary);
        bookLibraryOperation.executeCheckout();

        verify(bookLibrary).checkoutBook("name1");
    }

    @Test
    public void shouldNotCheckoutBookIfNotAvailable() {
        BookLibrary bookLibrary = mock( BookLibrary.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(bookLibrary.isBookAvailableForCheckOut(anyString())).thenReturn(false);

        BookLibraryOperation bookLibraryOperation = new BookLibraryOperation(consoleDisplay, bookLibrary);
        bookLibraryOperation.executeCheckout();

        verify(bookLibrary).checkoutBook("name1");
    }

    @Test
    public void shouldPrintSuccessMessageForSuccessfulCheckout() {
        BookLibrary bookLibrary = mock( BookLibrary.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(bookLibrary.isBookAvailableForCheckOut(anyString())).thenReturn(true);

        BookLibraryOperation bookLibraryOperation = new BookLibraryOperation(consoleDisplay, bookLibrary);
        bookLibraryOperation.executeCheckout();

        verify(consoleDisplay).putOutput("Checkout succesful");
    }

    @Test
    public void shouldPrintFailureMessageForUnSuccessfulCheckout() {
        BookLibrary bookLibrary = mock( BookLibrary.class);
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        when(consoleDisplay.getString()).thenReturn("name1");
        when(bookLibrary.isBookAvailableForCheckOut(anyString())).thenReturn(true);

        BookLibraryOperation bookLibraryOperation = new BookLibraryOperation(consoleDisplay, bookLibrary);
        bookLibraryOperation.executeCheckout();

        verify(consoleDisplay).putOutput("Checkout Not succesful");
    }
}