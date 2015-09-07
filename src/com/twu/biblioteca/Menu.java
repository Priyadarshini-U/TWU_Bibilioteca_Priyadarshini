package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> list = new ArrayList<String>() {{
        add("List Books");
        add("quit");
    }};

    public Object select(int i) {
        if( i == 1)
            return new Catalog();
        if( i == 2)
            exit();
        return new String("Invalid Menu");
    }

    public void exit() {
        System.exit(0);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
