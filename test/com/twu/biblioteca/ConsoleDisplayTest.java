package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

public class ConsoleDisplayTest {

    @Test
    public void shouldPrintObjectsToStringOutput() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        ConsoleDisplay display = spy(new ConsoleDisplay(System.in,new PrintStream(outContent)));

        Object object = new Object();
        display.putOutput(object);

        assertEquals(object.toString()+"\n", outContent.toString());
    }
}