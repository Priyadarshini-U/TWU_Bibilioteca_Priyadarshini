package com.twu.biblioteca;

public class MenuController implements IController {
    private ConsoleDisplay display;
    private Menu currentModel;
    private BookLibrary libraryData;

    public MenuController(ConsoleDisplay display, Menu current, BookLibrary libraryData) {
        this.currentModel = current;
        this.display = display;
        this.libraryData = libraryData;
    }


    @Override
    public IController executeAction() {
        display.putOutput(currentModel);
        String choice = display.getString();
        if(choice.equals("1"))
            return new Controller(display, libraryData, libraryData);
        if(choice.equals("3"))
            new BookLibraryOperation(display, libraryData).executeCheckout();
        return null;
    }
}
