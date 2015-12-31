package com.alienmade;

import com.alienmade.windows.Exit;
import com.alienmade.windows.Kontrahenci;
import com.alienmade.windows.Menu;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

public class Main {
    public static void main(String[] args) {
        final SwingTerminal swingTerminal = new SwingTerminal(200,50);
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen(swingTerminal);
        Router router = new Router(guiScreen);

        Window menu = new Menu("Menu", router);
        Window kontrahenci = new Kontrahenci("Kontrahenci", router);
        Window exit = new Exit("Exit", router);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(menu);


    }



}
