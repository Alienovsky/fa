package com.alienmade.windows;

import com.alienmade.ActionEnum;
import com.alienmade.listeners.EscapeKeyListener;
import com.alienmade.Router;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.terminal.TerminalSize;

public class Customer extends Window {
    private int numberOfColumns = 2;

    /**
     * Creates a new window
     *
     * @param title Title for the new window
     */
    public Customer(String title, final Router router) {
        super(title);
        router.addWindow(this);
        this.setWindowSizeOverride(new TerminalSize(130, 50));
        this.setSoloWindow(true);

        Panel mainPanel = new Panel(Panel.Orientation.VERTICAL);

        mainPanel.addComponent(prepareTopPanelWithSearchAndNewButton());
        mainPanel.addComponent(preparePanelWithCustomersTable());


        Button exit = new Button("Powrót", new Action() {
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

    private Panel preparePanelWithCustomersTable(){
        Panel mainPanel = new Panel(Panel.Orientation.VERTICAL);
        Table table = new Table(numberOfColumns);
        mainPanel.addComponent(table);

        table.setAlignment(Component.Alignment.CENTER);
        Label id = new Label("Id");Label company = new Label("Firma");Label name = new Label("Właściciel");
        table.addRow(id,company,name);

        for(Integer i=1; i<25; i++){
            table.addRow(new Button(i.toString()), new Label("PPHU NAME " +i), new Label("Imie "+i));
        }

        Panel buttonsPanel = new Panel(Panel.Orientation.HORISONTAL);
        Button goBackButton = new Button("<<");
        Button goFurtherButton = new Button(">>");
        buttonsPanel.addComponent(goBackButton);
        buttonsPanel.addComponent(goFurtherButton);
        mainPanel.addComponent(buttonsPanel);
        return mainPanel;
    }

    private Panel prepareTopPanelWithSearchAndNewButton(){
        Panel panel = new Panel(Panel.Orientation.HORISONTAL);
        TextBox textBox = new TextBox("Szukaj kontrahenta");
        Button addCustomerButton = new Button("Nowy");
        panel.addComponent(textBox);
        panel.addComponent(addCustomerButton);
        return panel;
    }



/*
    Panel tablesPanel = new Panel(Panel.Orientation.HORISONTAL);
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

    mainPanel.addComponent(tablesPanel);
*/




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
