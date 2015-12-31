package com.alienmade.windows;

import com.alienmade.ActionEnum;
import com.alienmade.Router;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.util.List;

public class Menu extends Window {
    /**
     * Creates a new window
     *
     * @param title Title for the new window
     */
    public Menu(String title, final Router router) {
        super(title);
        router.addWindow(this);

        this.setWindowSizeOverride(new TerminalSize(130, 50));
        this.setSoloWindow(true);

        Panel panel = new Panel(Panel.Orientation.VERTICAL);
        //panel.setBorder(new Border.Standard());
        panel.setTitle("");
        panel.setAlignment(Component.Alignment.CENTER);

        Button faktury = new Button("Faktury");
        faktury.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(faktury, LinearLayout.GROWS_HORIZONTALLY);

        panel.addComponent(new EmptySpace());

        Button kontrahenci = new Button("Kontrahenci", new Action() {
            @Override
            public void doAction() {
                router.action(ActionEnum.KONTRAHENCI);
            }
        });
        kontrahenci.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(kontrahenci,LinearLayout.GROWS_HORIZONTALLY);

        panel.addComponent(new EmptySpace());

        Button exit = new Button("Wyjście", new Action() {
            @Override
            public void doAction() {
                router.action(ActionEnum.EXIT_POPUP);
            }
        });
        exit.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(exit,LinearLayout.GROWS_HORIZONTALLY);
        this.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);
    }
}
