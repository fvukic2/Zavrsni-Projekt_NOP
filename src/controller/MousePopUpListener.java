package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Klasa koja nam osluskuje gdje smo kliknuli da nam se pokaze skocni izbornik
 * @author Filip
 */
public class MousePopUpListener extends MouseAdapter {

    /**
     * Objekt klase AppPopUpMenu
     */
    private final AppPopUpMenu appPopUpMenu;

    /**
     * Konstruktor klase MousePopUpListener
     * @param appPopUpMenu
     */
    public MousePopUpListener(AppPopUpMenu appPopUpMenu) {
        this.appPopUpMenu = appPopUpMenu;
    }

    /**
     * Metoda koja vraca da li je mouse event dogadaj popUp eventa
     * @param mev
     */
    public void mousePressed(MouseEvent mev) {
        if (mev.isPopupTrigger())
            doSomething(mev);
    }

    /**
     * Metoda koja vraca da li je mouse event dogadaj popUp eventa
     * @param mev
     */
    public void mouseReleased(MouseEvent mev) {
        if (mev.isPopupTrigger())
            doSomething(mev);
    }

    /**
     * Metoda koja pokazuje pop up meni na invokeru gdje se dogodio MouseEvent
     * @param mev
     */
    private void doSomething(MouseEvent mev) {
        if (mev.isPopupTrigger()) {
            appPopUpMenu.show(mev.getComponent(), mev.getX(), mev.getY());
        }
    }


}
