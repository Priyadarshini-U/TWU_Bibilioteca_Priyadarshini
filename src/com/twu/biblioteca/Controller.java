package com.twu.biblioteca;

public class Controller implements IController{
    private ConsoleDisplay display;
    private Object current;
    private BookLibrary libraryData;

    public Controller(ConsoleDisplay display, Object current, BookLibrary libraryData) {
        this.current =  current;
        this.display = display;
        this.libraryData = libraryData;
    }

    public IController executeAction() {
        display.putOutput(current);
        return new MenuController(display, new Menu(), libraryData);
    }
}
