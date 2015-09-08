package com.twu.biblioteca;

public class MenuController implements IController {
    private ConsoleDisplay display;
    private Menu current;

    public MenuController(ConsoleDisplay display, Menu current) {
        this.current = current;
        this.display = display;
    }

    public IController executeAction() {
        display.putOutput(current);
        int choice = display.getInteger();
        return new Controller(display, current.select(choice));
    }
}
