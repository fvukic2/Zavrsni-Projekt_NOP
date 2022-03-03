package controller;

import view.ViewPanel;

import javax.swing.*;

/**
 * Klasa u kojoj dodjeljujemo funkcionalnost metodama sucelja AllCommands
 * @author Filip
 */
public class CommandManager implements AllCommands {

    /**
     * Objekt klase JTextPane
     */
    private JTextPane jTextPane;

    /**
     * Konstruktor klase CommandManager
     * @param viewPanel
     */
    public CommandManager(ViewPanel viewPanel) {
        this.jTextPane = viewPanel.getjTextPane();

    }

    /**
     * Implementirana cut metoda iz AllCommands sucelja
     */
    @Override
    public void cut() {
        jTextPane.cut();

    }

    /**
     * Implementirana copy metoda iz AllCommands sucelja
     */
    @Override
    public void copy() {
        jTextPane.copy();

    }

    /**
     * Implementirana paste metoda iz AllCommands sucelja
     */
    @Override
    public void paste() {
        jTextPane.paste();

    }

    /**
     * Implementirana selectAll metoda iz AllCommands sucelja
     */
    @Override
    public void selectAll() {
        jTextPane.selectAll();
    }

}
