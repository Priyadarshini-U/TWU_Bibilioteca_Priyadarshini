package com.twu.biblioteca;

public class Controller implements IController{
    private ConsoleDisplay display;
    private Object current;

    public Controller(ConsoleDisplay display, Object current) {
        this.current =  current;
        this.display = display;
    }

    public IController executeAction() {
        display.putOutput(current);
        return new MenuController(display, new Menu());
    }
}
