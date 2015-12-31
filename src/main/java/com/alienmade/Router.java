package com.alienmade;

import com.alienmade.windows.Exit;
import com.alienmade.windows.Kontrahenci;
import com.alienmade.windows.Menu;
import com.googlecode.lanterna.gui.GUIScreen;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.screen.Screen;

import java.util.ArrayList;
import java.util.List;

public class Router {
    private List<Window> windows = new ArrayList<Window>();
    private GUIScreen screen;

    public Router(GUIScreen screen) {
        this.screen = screen;
    }

    public void action(ActionEnum action){
        if(action == action.EXIT){
            screen.getScreen().stopScreen();
            System.exit(0);
        }

        if(action == action.KONTRAHENCI){
            for(Window window : windows){
                if(window instanceof Kontrahenci){
                    screen.getActiveWindow().close();
                    screen.showWindow(window);
                }
            }

        }
        if(action == action.EXIT_POPUP){
            for(Window window : windows){
                if(window instanceof Exit){
                    screen.getActiveWindow().close();
                    screen.showWindow(window);
                }
            }
        }

        if(action == action.MENU){
            for(Window window : windows){
                if(window instanceof Menu){
                    screen.getActiveWindow().close();
                    screen.showWindow(window);
                }
            }

        }

    }

    public void addWindow(Window window){
        windows.add(window);
    }
}
