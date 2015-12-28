package com.alienmade;

import com.alienmade.windows.Kontrahenci;
import com.alienmade.windows.Menu;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.listener.WindowAdapter;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
        Router router = new Router(guiScreen);

        Window menu = new Menu("Menu", router);
        Window kontrahenci = new Kontrahenci("Kontrahenci", router);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(menu);
        guiScreen.getScreen().stopScreen();
    }



}
