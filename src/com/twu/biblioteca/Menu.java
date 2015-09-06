package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<String> list = new ArrayList<String>() {{
        add("List Books");
    }};

    public Object select(int i) {
        if( i == 1)
            return new Catalog();
        return new String("Invalid Menu");
    }
}
