package com.alienmade.windows;

import com.alienmade.ActionEnum;
import com.alienmade.Router;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.Button;
import com.googlecode.lanterna.gui.component.EmptySpace;
import com.googlecode.lanterna.gui.component.Label;
import com.googlecode.lanterna.gui.component.Panel;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Exit extends Window {
    /**
     * Creates a new window
     *
     * @param title Title for the new window
     */
    public Exit(String title, final Router router) {
        super(title);
        router.addWindow(this);
        this.setWindowSizeOverride(new TerminalSize(130, 50));
        this.setSoloWindow(true);

        Panel panel = prepareMainPanel();
        panel.addComponent(createPanelWithButtons(router));

        this.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);
    }

    private Panel prepareMainPanel(){
        Panel panel = new Panel(Panel.Orientation.VERTICAL);
        //panel.setBorder(new Border.Standard());
        panel.setAlignment(Component.Alignment.CENTER);
        Label qestion = new Label("Czy na pewno chcesz wyjść z programu?");
        qestion.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(qestion);
        return panel;
    }

    private Panel createPanelWithButtons(final Router router){
        Panel buttonsPanel = new Panel(Panel.Orientation.HORISONTAL);
        buttonsPanel.setAlignment(Component.Alignment.CENTER);
        Button yes = new Button("Tak", new Action() {
            @Override
            public void doAction() {
                router.action(ActionEnum.EXIT);
            }
        });
        Button no = new Button("Nie", new Action(){
            @Override
            public void doAction() {
                router.action(ActionEnum.MENU);
            }
        });
        yes.setAlignment(Component.Alignment.CENTER);
        no.setAlignment(Component.Alignment.CENTER);
        buttonsPanel.addComponent(yes, LinearLayout.GROWS_HORIZONTALLY);
        buttonsPanel.addComponent(new EmptySpace());
        buttonsPanel.addComponent(no, LinearLayout.GROWS_HORIZONTALLY);
        return buttonsPanel;
    }
}