package com.alienmade.Listeners;

import com.alienmade.ActionEnum;
import com.alienmade.Router;
import com.googlecode.lanterna.gui.Window;
import com.googlecode.lanterna.gui.listener.WindowAdapter;
import com.googlecode.lanterna.input.Key;

public class EscapeKeyListener extends WindowAdapter {
    Router router;

    public EscapeKeyListener(final Router router){
        this.router = router;
    }

    @Override
    public void onUnhandledKeyboardInteraction(Window window, Key key) {
        if(key.getKind() == Key.Kind.Escape){
            router.action(ActionEnum.MENU);
        }
    }
}
