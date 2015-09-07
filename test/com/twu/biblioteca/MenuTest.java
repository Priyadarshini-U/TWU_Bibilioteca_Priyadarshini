package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MenuTest {

    @Test
    public void shouldReturnCatalogOnSelectFirstOption() {
        assertEquals(new Menu().select(1).getClass(), Catalog.class);
    }

    @Test
    public void shouldReturnInvalidMessageOnWrongMenuSelection() {
        assertEquals(new Menu().select(-1).toString(), "Invalid Menu");
    }

    @Test
    public void shouldExitOnQuit() {
        Menu menu = mock(Menu.class);

        when(menu.select(2)).thenCallRealMethod();
        menu.select(2);

        verify(menu).exit();
    }

    @Test
    public void shouldReturnListAsString() {
        Menu menu = new Menu();

        assertEquals(menu.toString(), "[List Books, quit]");
    }
}