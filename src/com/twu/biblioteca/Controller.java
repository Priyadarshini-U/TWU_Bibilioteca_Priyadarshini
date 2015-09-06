package com.twu.biblioteca;

public class Controller {
    private ConsoleDisplay display;
    private Object current;

    public Controller(ConsoleDisplay display, Object current) {
        this.current =  current;
        this.display = display;
    }

    public Controller executeAction(ConsoleDisplay display, Object current) {
        /* Menu menu = new Menu();
        display.putOutput(current);
        display.putOutput(menu);
        int option = ()display.getInt();
        Object selectObject = menu.select(option);
        return new Controller(display, menu); */
        return null;
    }
}
