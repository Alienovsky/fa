package com.alienmade;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Main {
    public static void main(String[] args) {
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
        final Window window = new Window("Sample window");
        window.setWindowSizeOverride(new TerminalSize(130,50));
        window.setSoloWindow(true);

        Panel panel = new Panel(Panel.Orientation.VERTICAL);
        panel.setBorder(new Border.Standard());
        panel.setTitle("FA");
        panel.setAlignment(Component.Alignment.CENTER);

        Button faktury = new Button("Faktury");
        faktury.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(faktury,LinearLayout.GROWS_HORIZONTALLY);

        panel.addComponent(new EmptySpace());

        final Window kWindow = new Window("Kontrahenci");


        Button kontrahenci = new Button("Kontrahenci", new Action() {
            @Override
            public void doAction() {
                kWindow.setSoloWindow(true);
                kWindow.setWindowSizeOverride(new TerminalSize(130,50));
                guiScreen.showWindow(kWindow);
            }
        });
        kontrahenci.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(kontrahenci,LinearLayout.GROWS_HORIZONTALLY);

        panel.addComponent(new EmptySpace());

        Button exit = new Button("Wyjście", new Action() {
            @Override
            public void doAction() {
                window.close();
            }
        });
        exit.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(exit,LinearLayout.GROWS_HORIZONTALLY);


        window.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();

/*
        final GUIScreen guiScreen = TerminalFacade.createGUIScreen();
        final Window window = new Window("Sample window");
        window.setWindowSizeOverride(new TerminalSize(130,50));
        window.setSoloWindow(true);

        Panel panelHolder = new Panel("Holder panel", Panel.Orientation.VERTICAL);

        Panel panel = new Panel("Panel with a right-aligned button");

        panel.setLayoutManager(new VerticalLayout());
        Button button = new Button("Button");
        button.setAlignment(Component.Alignment.RIGHT_CENTER);
        panel.addComponent(button, LinearLayout.GROWS_HORIZONTALLY);

        Table table = new Table(6);
        table.setColumnPaddingSize(5);

        Component[] row1 = new Component[6];
        row1[0] = new Label("Field-1----");
        row1[1] = new Label("Field-2");
        row1[2] = new Label("Field-3");
        row1[3] = new Label("Field-4");
        row1[4] = new Label("Field-5");
        row1[5] = new Label("Field-6");

        table.addRow(row1);
        panel.addComponent(table);

        panelHolder.addComponent(panel);

        window.addComponent(panelHolder);
        window.addComponent(new EmptySpace());

        final Window newWindow = new Window("This window should be of the same size as the previous one");

        Button quitButton = new Button("Show next window", new Action() {

            public void doAction() {

                newWindow.setWindowSizeOverride(new TerminalSize(130,50));
                newWindow.setSoloWindow(true);



                Button exitBtn = new Button("Exit", new Action() {

                    public void doAction() {
                        // TODO Auto-generated method stub
                        newWindow.close();
                        window.close();
                    }
                });

                exitBtn.setAlignment(Component.Alignment.RIGHT_CENTER);

                newWindow.addComponent(exitBtn, LinearLayout.GROWS_HORIZONTALLY);

                guiScreen.showWindow(newWindow);
            }
        });
        quitButton.setAlignment(Component.Alignment.RIGHT_CENTER);
        window.addComponent(quitButton, LinearLayout.GROWS_HORIZONTALLY);

        guiScreen.getScreen().startScreen();
        guiScreen.showWindow(window);
        guiScreen.getScreen().stopScreen();*/

    }


}
