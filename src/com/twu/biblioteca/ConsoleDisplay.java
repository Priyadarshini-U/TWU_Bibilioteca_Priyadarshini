package com.twu.biblioteca;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsoleDisplay {
    private InputStream inputStream;
    private OutputStream outputStream;

    public ConsoleDisplay(InputStream in, OutputStream out) {
        this.inputStream = in;
        this.outputStream = out;
    }

    public void putOutput(Object object) {
        System.setOut((PrintStream) outputStream);
        System.out.println(object);
    }

    public int getInt(Object object) {
        System.setIn(inputStream);
        //inputStream.
        return -1;
    }
}
