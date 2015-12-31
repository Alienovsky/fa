package com.alienmade.windows;

import com.alienmade.ActionEnum;
import com.alienmade.Listeners.EscapeKeyListener;
import com.alienmade.Router;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.layout.LayoutManager;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.layout.VerticalLayout;
import com.googlecode.lanterna.gui.listener.ComponentAdapter;
import com.googlecode.lanterna.gui.listener.ComponentListener;
import com.googlecode.lanterna.gui.listener.WindowAdapter;
import com.googlecode.lanterna.gui.listener.WindowListener;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.TerminalSize;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.List;

public class Kontrahenci extends Window {
    /**
     * Creates a new window
     *
     * @param title Title for the new window
     */
    public Kontrahenci(String title, final Router router) {
        super(title);
        router.addWindow(this);
        this.setWindowSizeOverride(new TerminalSize(130, 50));
        this.setSoloWindow(true);

        Panel mainPanel = new Panel(Panel.Orientation.VERTICAL);

        Button exit = new Button("Powrót", new Action() {
            @Override
            public void doAction() {
                router.action(ActionEnum.MENU);
            }
        });
        exit.setAlignment(Component.Alignment.CENTER);
        mainPanel.addComponent(exit, LinearLayout.GROWS_HORIZONTALLY);

        this.addComponent(mainPanel, LinearLayout.GROWS_HORIZONTALLY);
        EscapeKeyListener escapeKeyListener = new EscapeKeyListener(router);
        addWindowListener(escapeKeyListener);
    }




      /*Panel tablesPanel = new Panel(Panel.Orientation.HORISONTAL);
        tablesPanel.setTitle("");
        tablesPanel.setAlignment(Component.Alignment.CENTER);
        Table table = new Table(3);
        table.setAlignment(Component.Alignment.CENTER);
        Label id = new Label("Id");Label company = new Label("Firma");Label name = new Label("Właściciel");
        table.addRow(id,company,name);

        for(Integer i=1; i<51; i++){
            table.addRow(new Button(i.toString()), new Label("PPHU NAME " +i), new Label("Imie "+i));
        }

        tablesPanel.addComponent(table, LinearLayout.GROWS_HORIZONTALLY);

        Table table2 = new Table(3);
        table2.setAlignment(Component.Alignment.CENTER);
        table2.addRow(id,company,name);

        for(Integer i=51; i<101; i++){
            table2.addRow(new Button(i.toString()), new Label("PPHU NAME " +i), new Label("Imie "+i));
        }
        tablesPanel.addComponent(new EmptySpace());
        tablesPanel.addComponent(table2, LinearLayout.GROWS_HORIZONTALLY);
        mainPanel.addComponent(tablesPanel);

        this.setWindowSizeOverride(new TerminalSize(table.getPreferredSize().getColumns()*2,table.getPreferredSize().getRows()));
        */
}
