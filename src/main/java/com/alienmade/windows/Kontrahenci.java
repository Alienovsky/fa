package com.alienmade.windows;

import com.alienmade.ActionEnum;
import com.alienmade.Router;
import com.googlecode.lanterna.gui.Action;
import com.googlecode.lanterna.gui.Border;
import com.googlecode.lanterna.gui.Component;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.layout.LinearLayout;
import com.googlecode.lanterna.gui.listener.ComponentAdapter;
import com.googlecode.lanterna.gui.listener.ComponentListener;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.TerminalSize;
import javafx.scene.input.KeyCode;

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

        Panel panel = new Panel(Panel.Orientation.VERTICAL);
        panel.setTitle("");
        panel.setAlignment(Component.Alignment.CENTER);
        Table table = new Table(1);
        table.setAlignment(Component.Alignment.CENTER);
        TextBox textBox = new TextBox();
        textBox.setText("ADA ADAMSKA");
        textBox.setPreferredSize(new TerminalSize(textBox.getText().length(), 1));
        table.addRow(textBox);
        panel.addComponent(table, LinearLayout.GROWS_HORIZONTALLY);

        Button exit = new Button("Wyjście", new Action() {
            @Override
            public void doAction() {
                router.action(ActionEnum.EXIT);
            }
        });
        exit.setAlignment(Component.Alignment.CENTER);
        panel.addComponent(exit,LinearLayout.GROWS_HORIZONTALLY);

        this.addComponent(panel, LinearLayout.GROWS_HORIZONTALLY);
    }
}
