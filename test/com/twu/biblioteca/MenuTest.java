package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {

    @Test
    public void shouldReturnCatalogOnSelectFirstOption() {
        assertEquals(new Menu().select(1).getClass(), Catalog.class);
    }

    @Test
    public void shouldReturnInvalidMessageOnWrongMenuSelection() {
        assertEquals(new Menu().select(-1).toString(), "Invalid Menu");
    }
}