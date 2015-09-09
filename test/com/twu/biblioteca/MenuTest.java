package com.twu.biblioteca;

import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void shouldReturnListAsString() {
        Menu menu = new Menu();

        assertEquals(menu.toString(), "[1. List Books, 2. quit, 3. CheckOut Book, 4. return Book]");
    }
}