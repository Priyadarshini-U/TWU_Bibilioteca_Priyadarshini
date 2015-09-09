package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<String> list = new ArrayList<String>() {{
        add("1. List Books");
        add("2. quit");
        add("3. CheckOut Book");
        add("4. return Book");
    }};

    @Override
    public String toString() {
        return list.toString();
    }
}
