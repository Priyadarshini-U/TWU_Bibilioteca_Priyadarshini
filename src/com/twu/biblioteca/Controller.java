package com.twu.biblioteca;

public class Controller {
    private ConsoleDisplay display;
    private Object current;

    public Controller(ConsoleDisplay display, Object current) {
        this.current =  current;
        this.display = display;
    }

    public Controller executeAction() {
        display.putOutput(current);
        return new Controller(display, new Menu());
    }
}
